package com.hand.hand.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by nishuai on 2017/11/22.
 */
public class Hospital implements Serializable{

    private Integer hid;
    private String hname;
    private String grade;
    private String address;
    private double longitude;
    private double latitude;
    private String introduce;
    private String picture;
   private List<Department> departmentList;


    public Hospital(){}

    public Hospital(Integer hid, String hname, String grade) {
        this.hid = hid;
        this.hname = hname;
        this.grade = grade;
    }

    public Hospital(Integer hid, String hname, String grade, String address, double longitude, double latitude, String introduce, String picture) {
        this.hid = hid;
        this.hname = hname;
        this.grade = grade;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.introduce = introduce;
        this.picture = picture;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

   public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
