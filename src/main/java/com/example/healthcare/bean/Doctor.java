package com.example.healthcare.bean;

import lombok.Data;

import javax.print.Doc;

import java.util.List;

@Data
public class Doctor {

    private String Did;

    private String DName;

    private String Dtelephone;

    //医生简介
    private String Profile;

    //医生科目
    private Integer SubjectId;

    //医院图片
    private String Dphoto;

    //医生问诊量
    private Integer Dseeing;

    //医生等级
    private Double Dgrade;

    private Integer TitleId;

    //医生的疾病科目
    private Integer diseaseId;

    //医生的个人简介
    private  String Dintroduc;

    //医生所在的医院
    private Hospital hospital;

    //医生的职业
    private Title title;

    //医生治疗的科目
    private Subject subject;

    //医生主治疾病
    private Disease disease;

    //医生的时间表
    private List<Time> time;

    private Price prices;

}
