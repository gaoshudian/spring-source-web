package com.zhuguang.jack.testbean.lookupMethod;


import com.zhuguang.jack.testbean.lookupMethod.People;

/**
 * 测试lookup-method属性的用法
 */
public abstract class ShowSixClass {

    public void showsix() {
        getPeople().showsix();
    }

    public abstract People getPeople();
}
