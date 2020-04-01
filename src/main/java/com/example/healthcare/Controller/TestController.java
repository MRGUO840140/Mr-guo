package com.example.healthcare.Controller;


import com.example.healthcare.Service.IUserService;
import com.example.healthcare.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("index")
    public String ins(){
        return "pageshow";
    }

    @RequestMapping("insert")
    public void insert(){
        //User user=new User("张三","男","123","18151130050","321084199710103615",1000.00);
        //iUserService.Insert(user);

    }
}
