package com.zhuguang.jack.customtag;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Node;

public class TagsNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        this.registerBeanDefinitionParser("mongo", new MongoBeanDifinitionParser());
        this.registerBeanDefinitionParser("redis", new RedisBeanDifinitionParser());
    }

    /*
    这里的bean使用的是默认的标签配置，但是其中的子元素却使用了自定义的配置
        对应源码:delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);

    <bean id="man" class="com.zhuguang.jack.entity.lookup_method.Man">
        <jack:redis id="redis" ip="127.0.0.1" port="6379"></jack:redis>
    </bean>
     */
    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        registerBeanDefinitionDecorator("redis", new MyBeanDefinitionDecorator());
        return super.decorate(node, definition, parserContext);
    }
}
