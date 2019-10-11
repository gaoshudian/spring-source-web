package com.zhuguang.jack.aop.cglib;

public class CglibProxyTest {
    public static void main(String[] args) {
        UserService userService = (UserService)CglibBeanFactory.getInstance();
        System.out.println(userService.myMethod("Jack"));
    }
}
