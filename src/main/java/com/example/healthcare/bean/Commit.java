package com.example.healthcare.bean;

import lombok.Data;

@Data
public class Commit {
    private Integer CommitId;
    private String Uid;
    private String DoctorId;
    private String Title;
    private String Memo;
    private Boolean sex;
    private Integer age;
    private String telephone;
    private Doctor doctor;


    public Commit(String uid, String doctorId, String title, String memo, String telephone) {
        Uid = uid;
        DoctorId = doctorId;
        Title = title;
        Memo = memo;
        this.telephone = telephone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCommitId() {
        return CommitId;
    }

    public void setCommitId(Integer commitId) {
        CommitId = commitId;
    }


    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String doctorId) {
        DoctorId = doctorId;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Commit() {
    }

//    @Override
//    public String toString() {
//        return "Commit{" +
//                "CommitId=" + CommitId +
//                ", Memo='" + Memo + '\'' +
//                ", Picture=" + Picture +
//                ", Uid=" + Uid +
//                ", DoctorId=" + DoctorId +
//                ", Title='" + Title + '\'' +
//                ", sex=" + sex +
//                ", age=" + age +
//                ", telephone='" + telephone + '\'' +
//                '}';
//    }
}
