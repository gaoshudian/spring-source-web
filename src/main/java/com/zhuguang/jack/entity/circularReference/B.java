package com.zhuguang.jack.entity.circularReference;

public class B {
    A a;

    public A getA() {
        return this.a;
    }

    public void setA(A a) {
        this.a = a;
    }

//    public B(A a) {
//        this.a = a;
//    }
}
