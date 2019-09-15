package com.zhuguang.jack.prototype;

public class PrototypeTest {

    public String username;

    private PrototypeTest2 prototypeTest2;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PrototypeTest2 getPrototypeTest2() {
        return prototypeTest2;
    }

    public void setPrototypeTest2(PrototypeTest2 prototypeTest2) {
        this.prototypeTest2 = prototypeTest2;
    }
}
