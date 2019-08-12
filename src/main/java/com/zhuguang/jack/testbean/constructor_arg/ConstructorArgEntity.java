package com.zhuguang.jack.testbean.constructor_arg;

import java.util.List;
import java.util.Map;

/**
 * 名称: ConstructorArgEntity.java
 * 描述: 测试constructor-arg属性的用法
 *
 * @author gaoshudian
 * @date 2019/8/12 10:19 AM
 */
public class ConstructorArgEntity {

    private Integer id;
    private String name;
    private boolean graduation;
    private List<String> dream;
    private Map<String, Integer> score;

    public ConstructorArgEntity() {

    }

    public ConstructorArgEntity(Integer id, String name, List<String> dream,
                   Map<String, Integer> score, boolean graduation) {
        this.id = id;
        this.name = name;
        this.dream = dream;
        this.score = score;
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", dream=" + dream
                + ", score=" + score + ", graduation=" + graduation + "]";
    }
}
