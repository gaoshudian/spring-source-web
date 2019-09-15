package com.zhuguang.jack.test;

import com.zhuguang.jack.MySmartFactoryBean;
import com.zhuguang.jack.entity.ListInjectTest;
import com.zhuguang.jack.entity.circularReference.A;
import com.zhuguang.jack.factoryBean.FactoryBeanTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

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

    @Test
    public void test(){
        ListInjectTest listInjectTest = (ListInjectTest)ac.getBean("injectTest");
        System.out.println(listInjectTest);
    }

    //测试bean的作用域为"prototype"的情况,每次获取的bean不是同一对象，hashCode不一样
    @Test
    public void prototypeTest() {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> System.err.println(ac.getBean("prototypeTest"))).start();
//        }
        ac.getBean("prototypeTest");
    }

    //测试bean的作用域为"prototype"时循环依赖的情况，这时会报错
    @Test
    public void prototypecircularreference() {
        ac.getBean("prototypeTestA");
        ac.getBean("prototypeTestB");
    }

}
