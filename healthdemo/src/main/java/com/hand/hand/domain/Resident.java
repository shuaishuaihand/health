package com.hand.hand.domain;

import java.io.Serializable;

/**
 * Created by nishuai on 2018/3/18.
 */
public class Resident implements Serializable {

    private Integer pid;
    private String pname;
    private Integer gender;
    private String birth;
    private String certificatetype;
    private String certificatenumber;
    private String phone;
    private String nationality;
    private String profession;
    private String education;
    private String marriage;
    private String habits;
    private Integer treatid;
    private Integer age;

    public Resident(Integer pid, String pname, Integer gender, String birth, String certificatetype, String certificatenumber, String phone, String nationality, String profession, String education, String marriage, String habits, Integer treatid, Integer age) {
        this.pid = pid;
        this.pname = pname;
        this.gender = gender;
        this.birth = birth;
        this.certificatetype = certificatetype;
        this.certificatenumber = certificatenumber;
        this.phone = phone;
        this.nationality = nationality;
        this.profession = profession;
        this.education = education;
        this.marriage = marriage;
        this.habits = habits;
        this.treatid = treatid;
        this.age = age;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    public String getCertificatenumber() {
        return certificatenumber;
    }

    public void setCertificatenumber(String certificatenumber) {
        this.certificatenumber = certificatenumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public Integer getTreatid() {
        return treatid;
    }

    public void setTreatid(Integer treatid) {
        this.treatid = treatid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
