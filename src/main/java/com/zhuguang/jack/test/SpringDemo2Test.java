package com.zhuguang.jack.test;

import com.zhuguang.jack.MySmartFactoryBean;
import com.zhuguang.jack.entity.circularReference.A;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2Test {

    ApplicationContext ac = null;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath*:config/spring/spring-demo2.xml");
    }

    //smartFactoryBean测试
    @Test
    public void smartFactoryBeanTest(){
        MySmartFactoryBean smartFactoryBeanTest = (MySmartFactoryBean)ac.getBean("mySmartFactoryBean");
        System.out.println(smartFactoryBeanTest);
    }

    //循环依赖测试
    @Test
    public void circularReferenceTest(){
        A a = (A) ac.getBean("a");
        System.out.println(a.getUsername());
    }

}
