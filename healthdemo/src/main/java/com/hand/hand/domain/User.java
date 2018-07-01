package com.hand.hand.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by nishuai on 2017/11/12.
 */
public class User implements Serializable{

    private Long id;
    private String name;
    private String phone;
    private String gender;
    private String telephone;
    private String address;
    private int enabled;
    private String username;
    private String password;
    private String remark;
    private String userface;
    //医院属性
    private Integer hid;
    private String hname;

    //用户角色
    private Role role;

    public User(Long id, String name, String phone, String gender, String telephone, String address, int enabled, String username, String password, String remark, String userface, Integer hid, String hname, Role role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.telephone = telephone;
        this.address = address;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.remark = remark;
        this.userface = userface;
        this.hid = hid;
        this.hname = hname;
        this.role = role;
    }

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
