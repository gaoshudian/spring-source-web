package com.zhuguang.jack.applicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;

/**
 * 通常用于需要对应用程序上下文进行一些编程初始化的web应用程序中
 * 比如说注册一些熟悉配置或者激活一些针对（ConfigurableApplicationContext的getEnvironment()上下文）的配置文件
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer,PriorityOrdered {
    //在spring容器初始化之前对spring的上下文做一些修改
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("===========MyApplicationContextInitializer");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
