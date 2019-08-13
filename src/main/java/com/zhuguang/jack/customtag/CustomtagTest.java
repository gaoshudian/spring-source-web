package com.zhuguang.jack.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * 自定义标签测试
 */
public class CustomtagTest {
    
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("customtag.xml");
        System.out.println(app);

        Jedis client1 = (Jedis)app.getBean("redis");
        System.out.println(client1);
        
//        System.out.println(client1.set("keyname1", "valuejack1"));
    }
}
