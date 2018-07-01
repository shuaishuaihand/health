package com.hand.hand.domain;

import java.io.Serializable;

/**
 * Created by nishuai on 2018/3/19.
 */
public class Chartdata implements Serializable {

    private String name;  //数据名称
    private Integer value; //数据值

    public Chartdata(){}

    public Chartdata(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
