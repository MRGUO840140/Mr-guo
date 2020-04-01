package com.example.healthcare.bean;

import lombok.Data;

@Data
public class Disease {
    private Integer diseaseId;

    private String diseaseName;

    private String Article;

    private Subject subject;

}
