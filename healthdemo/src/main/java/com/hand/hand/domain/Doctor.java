package com.hand.hand.domain;

import java.io.Serializable;

/**
 * Created by nishuai on 2017/12/6
 */
public class Doctor implements Serializable{

    private Integer id;
    private String name;  //医生姓名
    private String idnumber; //身份证号
    private String practicenumber; //职业编号
    private String professionaltitle; //职称
    private String gender; //性别
    private Integer age; //年龄
    private String phone; //电话号码
    private String speciality; //医生擅长
    private String introduce;  //医生介绍
    private Department department;

    public Doctor() {}

    public Doctor(Integer id, String name, String idnumber, String practicenumber, String professionaltitle, String gender, Integer age, String phone, String speciality, String introduce) {
        this.id = id;
        this.name = name;
        this.idnumber = idnumber;
        this.practicenumber = practicenumber;
        this.professionaltitle = professionaltitle;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.speciality = speciality;
        this.introduce = introduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPracticenumber() {
        return practicenumber;
    }

    public void setPracticenumber(String practicenumber) {
        this.practicenumber = practicenumber;
    }

    public String getProfessionaltitle() {
        return professionaltitle;
    }

    public void setProfessionaltitle(String professionaltitle) {
        this.professionaltitle = professionaltitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
