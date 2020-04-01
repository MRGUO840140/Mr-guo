package com.example.healthcare.bean;

import lombok.Data;

@Data
public class Time {

    private Integer TimeId;

    private String Did;

    private String Data;

    private String Day;

    private String MorAfter;

    //限定的人数
    private Integer Account;

}
