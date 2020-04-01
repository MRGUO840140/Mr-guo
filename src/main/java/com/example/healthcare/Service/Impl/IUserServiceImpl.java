package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.IUserService;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.bean.User;
import com.example.healthcare.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public void Insert(User user) {
        iUserMapper.Insert(user);
    }

    @Override
    public User Login(User user) {

        return iUserMapper.Login(user);
    }

    @Override
    public User LoginTel(String Utelephone) {
        return iUserMapper.LoginTel(Utelephone);
    }

    @Override
    public User getUserById(String Uid) {
        return iUserMapper.getUserById(Uid);
    }

    @Override
    public User CheckUname(String Uname) {
        return iUserMapper.CheckUname(Uname);
    }

    @Override
    public User CheckTel(String Tel) {
        return iUserMapper.CheckTel(Tel);
    }

    @Override
    public void UpdateUserInfo(User user) {
        iUserMapper.UpdateUserInfo(user);
    }

    @Override
    public void UpdateUserpwd(String Uid,String Upassword) {
        iUserMapper.UpdateUserpwd(Uid,Upassword);
    }

    @Override
    public void UpdateUserCount(User user) {
        iUserMapper.UpdateUserCount(user);
    }

    @Override
    public void InsertUserInfo(String Utelephone, String Uname, String Uidnumber, String Uid) {
        iUserMapper.InsertUserInfo(Utelephone,Uname,Uidnumber,Uid);
    }

    @Override
    public User getAllOrd(String Uid) {
        return iUserMapper.getAllOrd(Uid);
    }
}
