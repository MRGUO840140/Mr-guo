package com.example.healthcare.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String Picture;




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
