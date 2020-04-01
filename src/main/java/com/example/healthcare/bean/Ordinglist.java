package com.example.healthcare.bean;

import lombok.Data;

@Data
public class Ordinglist {

    private Integer OrdingId;

    private String Uid;

    private String Did;

    private Integer PriceId;

    private Integer TimeId;

    //是否复诊
    private Integer isVisit;

    //疾病的信息
    private String diseaseInfo;

    //是否支付
    private Integer isPay;

    private Time time;

    private User user;

    private Doctor doctor;

    private Price price;

    private Title title;

}
