package com.zhuguang.jack.test.loadDocument;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * 名称: LoadDocumentTest.java
 * 描述: 模拟spring将xml配置文件解析成Document对象的过程
 *
 * @author gaoshudian
 * @date 2019/8/12 3:09 PM
 */
public class LoadDocumentTest {


    private static final Log logger = LogFactory.getLog(LoadDocumentTest.class);

    private ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger);

    @Test
    public void domTest() throws Exception {
        Resource resource = new ClassPathResource("config/spring/applicationContext-core.xml", Thread.currentThread().getContextClassLoader());
        EncodedResource encodedResource = new EncodedResource(resource);
        InputStream inputStream = encodedResource.getResource().getInputStream();
        InputSource inputSource = new InputSource(inputStream);

        MyDocumentLoader myDocumentLoader = new MyDocumentLoader();

        Document document = myDocumentLoader.loadDocument(inputSource,new MyEntityResolver(),this.errorHandler,3,false);
//        Document document = myDocumentLoader.loadDocument(inputSource, null, this.errorHandler, 3, false);

        Element root = document.getDocumentElement();
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            System.out.println(node.getNodeName() + "。。。" + node.getNodeValue());
        }

    }
}
