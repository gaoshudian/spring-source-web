package com.zhuguang.jack.entity.lookup_method;

import com.zhuguang.jack.entity.Son;

public class Man implements People {

//    @Lazy
//    @Autowired
    Son son;

    @Override
    public void showsix() {
        System.out.println("i am man!");
    }
}
