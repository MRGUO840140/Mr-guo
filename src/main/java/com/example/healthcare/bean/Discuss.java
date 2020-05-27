package com.example.healthcare.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName:
 * @Author Mr GuoQing
 * @Date: 2020/4/17 20:48
 * @Description: 文章类
 */
@Data
public class Discuss {

    private Long Id;

    private String title;

    private Long Did;

    private String text;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    private Doctor doctor;

    private String cut;


    public void Cut(String text){

        String substring = text.substring(0, 500).replace("&nbsp;","")+"...";
        this.cut = substring;
    }
}
