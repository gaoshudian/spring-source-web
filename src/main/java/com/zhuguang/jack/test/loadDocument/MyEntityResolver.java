package com.zhuguang.jack.test.loadDocument;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称: MyEntityResolver.java
 * 描述:
 *
 官方解释: 如果 SAX 应用程序需要实现自定义处理外部实体,则必须实现此接口,并使用setEntityResolver方法向SAX 驱动器注册一个实例.

  也就是说,对于解析一个xml,sax首先会读取该xml文档上的声明,根据声明去寻找相应的dtd定义或xsd定义,以便对文档的进行验证；
  默认的寻找规则是通过网络,实现上就是通过声明DTD的URI地址来下载DTD声明并进行认证,下载的过程是一个漫长的过程,而且当网络不可用时,
  这里会报错,就是应为相应的dtd没找到。

  EntityResolver 的作用就是项目本身就可以提供一个如何寻找DTD的声明方法；
  即:由程序来实现寻找DTD声明的过程,比如我们将DTD放在项目的某处，在实现时直接将此文档读取并返回给SAX即可,这样就避免了通过网络来寻找DTD的声明

 * @author gaoshudian
 * @date 2019/8/12 3:30 PM
 */
public class MyEntityResolver implements EntityResolver {

    private static final Log logger = LogFactory.getLog(MyEntityResolver.class);

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException {
        if (logger.isTraceEnabled()) {
            logger.trace("Trying to resolve XML entity with public id [" + publicId +
                    "] and system id [" + systemId + "]");
        }

        if (systemId != null) {
            String resourceLocation = getSchemaMappings().get(systemId);
            if (resourceLocation != null) {
                Resource resource = new ClassPathResource(resourceLocation, Thread.currentThread().getContextClassLoader());
                try {
                    InputSource source = new InputSource(resource.getInputStream());
                    source.setPublicId(publicId);
                    source.setSystemId(systemId);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Found XML schema [" + systemId + "] in classpath: " + resourceLocation);
                    }
                    return source;
                }
                catch (FileNotFoundException ex) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Couldn't find XML schema [" + systemId + "]: " + resource, ex);
                    }
                }
            }
        }
        return null;
    }

    public Map<String, String> getSchemaMappings(){
        Map<String, String> schemaMappings = new HashMap<>();
        schemaMappings.put("http://www.springframework.org/schema/beans/spring-beans-4.3.xsd","org/springframework/beans/factory/xml/spring-beans-4.3.xsd");
        return schemaMappings;
    }
}
