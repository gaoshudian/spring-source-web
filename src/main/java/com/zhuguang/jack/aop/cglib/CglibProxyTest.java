package com.zhuguang.jack.aop.cglib;

/**
 * cglib动态代理测试
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        UserService userService = (UserService) CglibBeanFactory.getInstance();
        System.out.println(userService.doSomething1("Jack"));
    }

}
