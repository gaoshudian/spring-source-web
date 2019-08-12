package com.zhuguang.jack.testbean.lookup_method;


/**
 * 测试lookup-method属性的用法
 */
public abstract class ShowSixClass {

    public void showsix() {
        getPeople().showsix();
    }

    public abstract People getPeople();
}
