package com.zhuguang.jack.customtag;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @Description: 自定义装饰器，主要应用这种配置情况：

    这里的bean使用的是默认的标签配置，但是其中的子元素却使用了自定义的配置
    <bean id="man" class="com.zhuguang.jack.entity.lookup_method.Man">
        <jack:redis id="redis" ip="127.0.0.1" port="6379"></jack:redis>
    </bean>
    对应源码:delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);

    其实这里就是把默认标签解析出来的BeanDefinitionHolder进一步装饰（修改）

 * @Auther: gaoshudian
 * @Date: 2019/8/13 21:56
 */
public class MyBeanDefinitionDecorator implements BeanDefinitionDecorator{
    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        //自定义装饰操作
        String ip = ((Element)node).getAttribute("ip");
        String port = ((Element)node).getAttribute("port");
        //其它操作
        //......
        return definition;
    }
}
