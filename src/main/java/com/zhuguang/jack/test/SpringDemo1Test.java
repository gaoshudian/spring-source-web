package com.zhuguang.jack.test;

import com.zhuguang.jack.entity.lookup_method.ShowSixClass;
import com.zhuguang.jack.entity.replaced_method.OriginClass;
import com.zhuguang.jack.typeConverter.TypeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1Test {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:config/spring/spring-demo1.xml");

    @Test
    public void converterTest(){
        TypeClass typeClass = (TypeClass) ctx.getBean("typeClass");
        System.out.println(typeClass);
    }

    @Test
    public void lookup_methodTest(){
        ShowSixClass showSixClass = (ShowSixClass) ctx.getBean("people");
        showSixClass.showsix();
    }

    @Test
    public void replaced_methodTest(){
        OriginClass originClass = (OriginClass) ctx.getBean("originClass");
        originClass.method();
    }

}
