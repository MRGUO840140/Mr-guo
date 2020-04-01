package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

@Data
public class Hospital {

    private Integer HospitalId;

    //医院名称
    private String HospitalName;

    //医院等级
    private String level;

    //医院地点
    private String PositionCity;

    //医院图片地址
    private String HospitalPhoto;

    //医院地址
    private String HospitalAdd;

    private String HospitalTel;

    //医院订单数
    private Double OrderCount;

    //医院预约量
    private Double Patienteval;

    //医院简介
    private String  introduction;

    //医院中的医生表
    private List<Doctor> doctors;

    //医院中的科目表
    private List<Subject> subjects;

}
