package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String Uid;

    private String Uloginname;

    private String Uname;

    private String Usex;

    private String Upassword;

    private String Utelephone;

    private String Uidnumber;

    private String Umail;

    private Double Ucount;

    //挂号单子
    private List<Ordinglist> list;

    public User() {
    }

    /*这边时*/
    public User(String uid, String uloginname, String uname, String usex, String utelephone, String uidnumber, String umail) {
        Uid = uid;
        Uloginname = uloginname;
        Uname = uname;
        Usex = usex;
        Utelephone = utelephone;
        Uidnumber = uidnumber;
        Umail = umail;
    }

    /*这边时用户登录时session的存储信息*/

    public User(String uid, String uloginname, String uname, String usex, String upassword, String utelephone, String uidnumber, String umail, Double ucount) {
        Uid = uid;
        Uloginname = uloginname;
        Uname = uname;
        Usex = usex;
        Upassword = upassword;
        Utelephone = utelephone;
        Uidnumber = uidnumber;
        Umail = umail;
        Ucount = ucount;
    }
}
