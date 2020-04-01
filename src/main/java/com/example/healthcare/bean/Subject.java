package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private Integer SubjectId;

    private String Subject;

    private Doctor doctor;

    private List<Disease> diseases;

}
