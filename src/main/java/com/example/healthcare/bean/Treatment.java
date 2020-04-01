package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

@Data
public class Treatment {

    private Integer TreatmentId;

    //治疗方式
    private String Treatment;

    //不同方式的价格表
    private List<Price> list;


}
