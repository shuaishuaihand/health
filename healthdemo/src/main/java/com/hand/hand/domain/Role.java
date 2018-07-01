package com.hand.hand.domain;

/**
 * Created by nishuai on 2018/3/20.
 */
public class Role {
    private Long rid;
    private String name;
    private String nameZh;

    public Role(){}

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
