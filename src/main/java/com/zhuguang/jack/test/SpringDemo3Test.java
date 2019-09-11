package com.zhuguang.jack.test;

import com.zhuguang.jack.MySmartFactoryBean;
import com.zhuguang.jack.entity.circularReference.A;
import com.zhuguang.jack.factoryBean.FactoryBeanTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3Test {

    ApplicationContext ac = null;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath*:config/spring/spring-demo3.xml");
    }

    //smartFactoryBean测试
    @Test
    public void smartFactoryBeanTest(){
        FactoryBeanTest factoryBeanTest = (FactoryBeanTest)ac.getBean("factoryBeanTest");
        System.out.println(factoryBeanTest);
    }


}
