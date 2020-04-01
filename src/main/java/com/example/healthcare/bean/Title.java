package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

@Data
public class Title {

    private Integer DTid;

    //医生职业
    private String Title;

    private List<Doctor> doctor;


}
