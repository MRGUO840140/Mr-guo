package com.example.healthcare.Controller;
import com.example.healthcare.Service.IUserService;
import com.example.healthcare.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private IUserService iUserService;
    /*跳转到注册页*/
    @RequestMapping("/user/register")
    public String register(){
        return "register";
    }

    /*首页跳转*/
    @RequestMapping("/user/main")
    public String main(){
        return "redirect:/main.html";
    }

    /*注册成功跳转首页*/
    @PostMapping("/user/pwd")
    public String success(User user, Model model, RedirectAttributes redirectAttributes) throws IOException {
        Map<String,Object> map=new HashMap<>();
        System.out.println(user);
        User user1 = iUserService.CheckUname(user.getUloginname());
        User user2=iUserService.CheckTel(user.getUtelephone());
        if(user1==null&&user2==null){
            iUserService.Insert(user);
            redirectAttributes.addFlashAttribute("success","注册成功，欢迎登录");
            return "redirect:/login.html";
        }else{
            model.addAttribute("msgfail","用户名或者手机号存在,请重新输入");
            return "register";
        }
    }

    /*@GetMapping("/user/checkUname")
    @ResponseBody
    public Map<String,Object> CheckOut(String Uloginname){
        Map<String,Object> map=new HashMap<>();
        User user = iUserService.CheckUname(Uloginname);
        if (user!=null){
            map.put("msg","用户名已存在");
            return map;
        }else {
            return map;
        }
    }*/
}
