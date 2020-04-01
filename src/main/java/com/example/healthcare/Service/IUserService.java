package com.example.healthcare.Service;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    /**
     * 作为插入数据使用
     */
    void Insert(User user);

    /**
     * 用户登录密码
     * @param user
     * @return
     */
    User Login(User user);
    /**
     * 手机号登录
     */
    User LoginTel(String Utelephone);

    /**
     * 根据用户id进行查找用户
     * @param
     * @return
     */
    User getUserById(String Uid);

    /**
     * 对用户名进行校验
     * @param Uname
     * @return
     */
    User CheckUname(@Param("Uname")String Uname);

    /**
     * 对用户电话进行校验
     * @param Tel
     * @return
     */
    User CheckTel(@Param("Tel")String Tel);

    /**
     * 对用户中心个人信息进行修改
     * @param user ：密码，账户余额不能修改
     */
    void UpdateUserInfo(User user);

    /**
     * 用户修改密码
     * @param user
     */
    void UpdateUserpwd(String Uid,String Upassword);

    /**
     * 对账户余额进行充值
     * @param user
     */
    void UpdateUserCount(User user);

    /**
     * 这里对用户信息挂号时进行完善
     * @param Utelephone
     * @param Uname
     * @param Uidnumber
     */
    void InsertUserInfo(@Param("Utelephone") String Utelephone,@Param("Uname") String Uname,@Param("Uidnumber") String Uidnumber,@Param("Uid") String Uid);

    /**
     * 得到用户的挂号单
     * @param Uid
     * @return
     */
    User getAllOrd(String Uid);

}
