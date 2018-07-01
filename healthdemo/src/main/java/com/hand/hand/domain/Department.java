package com.hand.hand.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nishuai on 2017/12/6
 */
public class Department implements Serializable{

    private String did;
    private String dname;
    private String introduce;
    private Integer hid;
    private List<Doctor> doctorList;

    public Department(){}

    public Department(String did, String dname, String introduce, List<Doctor> doctorList) {
        this.did = did;
        this.dname = dname;
        this.introduce = introduce;
        this.doctorList = doctorList;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
}
