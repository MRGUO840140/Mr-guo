package com.example.healthcare.bean;

import lombok.Data;

@Data
public class Price {

    private Integer PriceId;

    private Integer DTid;

    private Double price;

    private Integer TreatmentId;

    //医生的职称
    private Title title;

    //治疗方式
    private Treatment treatment;

}
