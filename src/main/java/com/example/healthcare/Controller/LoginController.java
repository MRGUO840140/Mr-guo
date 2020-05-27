package com.example.healthcare.Controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.healthcare.Service.CommitService;
import com.example.healthcare.Service.IUserService;
import com.example.healthcare.Service.OrdinglistService;
import com.example.healthcare.bean.Commit;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.bean.PageHelper;
import com.example.healthcare.bean.User;
import com.example.healthcare.config.OSSClientUtil;
import com.example.healthcare.config.yanzhen.RestTest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.example.healthcare.Controller.yanzhengmaController.LOGIN_VALIDATE_CODE;

@Controller
public class LoginController {
    String param=null;


    @Autowired
    private IUserService iUserService;
    @Autowired
    private OrdinglistService ordinglistService;
    @Autowired
    private CommitService commitService;

    /**
     * 默认首页跳转
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "pageshow";
    }

    /**
     * 登录：用户名+密码
     * @param
     * @param Upassword
     * @param map
     * @return :跳转到首页
     */
    @PostMapping("/user/login")
    public String login(HttpSession session, @RequestParam("Uloginname") String Uloginname, @RequestParam("Upassword") String Upassword, Map<String,Object> map){
        User user=new User();
        user.setUloginname(Uloginname);
        user.setUpassword(Upassword);
        User user1=iUserService.Login(user);
        OSSClientUtil ossClientUtil = new OSSClientUtil();
        user1.setUphoto(ossClientUtil.getImgUrl(user1.getUphoto()));
        if(!StringUtils.isEmpty(Uloginname)&&!StringUtils.isEmpty(Upassword)&&user1!=null){
            session.setAttribute("user",user1);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }

    @PostMapping("/api/user/login")
    @ResponseBody
    public Object login1(HttpSession session, User user2, Map<String,Object> map){
        //System.err.println(user2);
        User user1=iUserService.Login(user2);

        if(ObjectUtils.isEmpty(user1)){
            map.put("success",false);
            return  JSON.parse(map.toString());
        }

        map.put("token","123456789");
        map.put("success",true);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        return s;
    }

    /**
     * 退出当前账户
     * @param session
     * @return ：返回到登录页面
     */
    @RequestMapping("/user/exit")
    public String Exit(HttpSession session){
        session.getAttribute("user");
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 点击用户名跳转到用户中心
     * @return
     */
    @RequestMapping("/user/center")
    public String Center(HttpServletRequest req,Model model){
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        int pn=1;
        if(req.getParameter("pn")!=null){
            pn=Integer.parseInt(req.getParameter("pn"));
        }
        System.out.println("pn="+pn);
        PageHelper pageHelper=new PageHelper();
        pageHelper.setCurrentPage(pn);
        int pageSize=4;
        pageHelper.setPageSize(pageSize);
        List<Ordinglist> ords = ordinglistService.getOrdsByPage(user.getUid(),pn,pageSize);
        pageHelper.setListItems(ords);
        int totalPages=ordinglistService.getTotalOrds(user.getUid());
        pageHelper.setTotalPages(totalPages);
        int pageCount=(totalPages%pageSize==0?(totalPages/pageSize):(totalPages/pageSize+1));
        pageHelper.setPageCount(pageCount);
        session.setAttribute("pageHelper",pageHelper);
        List<Commit> tuwenCommits=commitService.selectTuwen(user.getUid());
        session.setAttribute("tuwenCommits",tuwenCommits);
        List<Commit> jisuCommits=commitService.selectJisu(user.getUid());
        session.setAttribute("jisuCommits",jisuCommits);
        return "PersonalCenter";
    }

    /**
     * 用户密码修改
     * @param session
     * @param
     * @return
     */
    @PostMapping("/user/pass")
    @ResponseBody
    public String setPass(HttpSession session,String UPassword,String OldUPassword){
        System.out.println("新密码为："+UPassword);
        System.out.println("旧密码为："+OldUPassword);
        User user=(User)session.getAttribute("user");
        User userById = iUserService.getUserById(user.getUid());
        if(userById.getUpassword().equals(OldUPassword)){
            iUserService.UpdateUserpwd(user.getUid(),UPassword);
            return "修改成功";
        }else{
            return "与原密码一致";
        }

    }

    @PostMapping("/user/jiaopass")
    @ResponseBody
    public String yanpass(HttpSession session,String OldUPassword){
        User user=(User)session.getAttribute("user");
        User userById = iUserService.getUserById(user.getUid());
        if(userById.getUpassword().equals(OldUPassword)){
            return "正确";
        }else{
            return "错误";
        }
    }


    @RequestMapping("/user/commit")
    public String Commit(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        ordinglistService.getOrds(user.getUid());
        List<Ordinglist> ords = ordinglistService.getOrds(user.getUid());
        model.addAttribute("list",ords);
        return "PersonalCenter";
    }
    /**
     *
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/user/setInfo")
    public String SetInfo(HttpSession session, HttpServletRequest request,User user1){
        System.out.println(user1);
        User user=(User)session.getAttribute("user");
        String Uname=request.getParameter("Uname");
        String Usex=request.getParameter("Usex");
        String Utelephone=request.getParameter("Utelephone");
        String Uidnumber=request.getParameter("Uidnumber");
        String Umail=request.getParameter("Umail");
        user.setUname(Uname);
        user.setUsex(Usex);
        user.setUtelephone(Utelephone);
        user.setUidnumber(Uidnumber);
        user.setUmail(Umail);
        iUserService.UpdateUserInfo(user);
        return "PersonalCenter";
    }

    /*以下为手机号码登录*/
    @GetMapping("/user/mobilephone")
    @ResponseBody
    public Object Yanzheng(HttpSession session,String phone){
        String methodNumber ="1";
        if (methodNumber.equals("1")) {  //指定模板单发
            String sid = "2ed76a12c6516c7f998d567e12bd1417";
            String token = "8565f3c2aa73f257cf5ea07858cedb43";
            String appid = "50d08efd1c5241b5bdf9be56009bb913";
            String templateid = "504741";
            //int i = (int) ((Math.random() * 9 + 1) * 100000);
            session.setAttribute("phone",param = String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
            String mobile = phone;
            String uid = "";
            session.setMaxInactiveInterval(60);
            RestTest.testSendSms(sid, token, appid, templateid, param, mobile, uid);
        }
        return "验证码已发送，请注意查收";
    }


    //手机登录的接口
   @PostMapping("/user/LoginTel")
    public String LoginTel(HttpServletRequest request, HttpServletResponse response, HttpSession session, String Utelephone, String dongtai, String validateCode, Model model) throws IOException {
       System.out.println(validateCode);
       String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
       Object phone = session.getAttribute("phone");    //从session中取值，从而进行验证码过期时间
       System.out.println("session中的为："+phone);
       User user = iUserService.LoginTel(Utelephone);
       if (user!=null&&dongtai.equals(phone) && loginValidateCode.equals(validateCode)){
           session.setAttribute("user",user);
           return "redirect:/main.html";
       }else{
           model.addAttribute("error","登录失败");
           return "login";
       }
   }
}
