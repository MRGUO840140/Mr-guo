package com.example.healthcare.Controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.healthcare.Service.*;
import com.example.healthcare.bean.*;
import com.example.healthcare.config.OSSClientUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class GuaHaoController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private TimeService timeService;

    @Autowired
    private OrdinglistService ordinglistService;

    @Autowired
    private CommitService commitService;
    /**
     * 点击预约挂号进入选择地区页面
     * @return
     */
    @GetMapping("/user/Ording")
    public String Area(){
        return "Ording";
    }


    /**
     * 这边查找出对应的医院
     * @param
     * @param PositionCity
     * @return
     */
    @GetMapping("/user/Ordings")
    @ResponseBody
    public List<Hospital> getAllHos( String PositionCity){
        List<Hospital> hospital = hospitalService.getHospital(PositionCity);
        System.out.println(hospital);
        return hospital;
    }

    /**
     * 根据医院名称选出相应的科目
     * @param HospitalName
     * @return
     */
    @GetMapping("/user/subject")
    @ResponseBody
    public List<Subject> getSub(String HospitalName){
        List<Hospital> hospitalSub = hospitalService.getHospitalSub(HospitalName);
        List<Subject> subjects=null;
        System.out.println(hospitalSub);
        for (Hospital h:hospitalSub){
          subjects = h.getSubjects();
        }
        return subjects;
    }

    @GetMapping("user/disease")
    @ResponseBody
    public List<Disease> getDis(String SubjectName){
        Subject subject = subjectService.getDiseases(SubjectName);
        System.out.println(subject);
        List<Disease> diseases = subject.getDiseases();
        System.out.println(diseases);
        return diseases;
    }

    /**
     * 提交表单到筛选出的页面
     */
    @GetMapping("/user/Diabetes")
    public String Diabetes(Model model, HttpServletRequest request, @RequestParam(value = "pn",defaultValue = "1") Integer pn){
        OSSClientUtil ossClientUtil = new OSSClientUtil();
         Integer hospitalid= Integer.parseInt(request.getParameter("hospital"));
         Integer subjectid=Integer.parseInt(request.getParameter("object"));
         Integer diseaseid=Integer.parseInt(request.getParameter("disease"));
        Hospital hospital= hospitalService.getInfo(hospitalid); //保存这医院的全部信息
        Disease disease = diseaseService.getDisease(diseaseid);//拿到疾病的详细信息
        Subject sub = subjectService.getSub(subjectid);//拿到当前科目的名称
        Hospital docInfo = hospitalService.getDocInfo(hospitalid, subjectid,diseaseid);
        List<Doctor> doctors = docInfo.getDoctors();//拿到医院下同科室所有医生信息
        /*开始处理分页*/
        PageHelper.startPage(pn,4);
        List<Hospital> hospitals = hospitalService.getHospital(hospital.getPositionCity());//当前市的所有医院
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
        //封装了详细的信息，包括查询出来的数据
        PageInfo<Hospital> page=new PageInfo<>(hospitals,4); //1为连续显示的页数
        List<Hospital> list = page.getList();
        for (Hospital h:list){
          h.setHospitalPhoto(ossClientUtil.getImgUrl(h.getHospitalPhoto()));
        }
        model.addAttribute("pageInfo",page); //存储分页的详细信息
        model.addAttribute("hospital",hospital);
        model.addAttribute("disease",disease);
        model.addAttribute("subject",sub);
        model.addAttribute("doctors",doctors);
        model.addAttribute("hospitals",hospitals);
        return "Diabetes";
    }

    @GetMapping("/user/ord")
    public String Ording(){
        return "Ording";
    }
    @GetMapping("/user/PageHelper")
    @ResponseBody
    public Object getPageInfo(Model model,String positionCity,@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        OSSClientUtil ossClientUtil = new OSSClientUtil();
        PageHelper.startPage(pn,4);
        List<Hospital> hospitals = hospitalService.getHospital(positionCity);
        PageInfo<Hospital> page=new PageInfo<>(hospitals,4); //1为连续显示的页数
        List<Hospital> list = page.getList();
         for (Hospital hos:list){
             hos.setHospitalPhoto(ossClientUtil.getImgUrl(hos.getHospitalPhoto()));
        }
        model.addAttribute("hospitals",hospitals);
         model.addAttribute("page",page);
        return page;
    }

    /**
     * 进入医生信息挂号阶段
     * 跳转到医生信息
     */
    @GetMapping("/user/Guahao/{Did}")
    public String Guahao(@PathVariable("Did") String Did,Model model){
        Doctor doc = doctorService.getDoc(Did);                 //拿到医生的对象
        List<Time> time = doc.getTime();                         //医生的时间表
        List<Time> FilterTime=new ArrayList<>();
        for (Time t:time) {
            if(t.getAccount()>=0){
                FilterTime.add(t);
            }
        }
        Integer dTid = doc.getTitle().getDTid();                   //拿到价格查相应的价格
        Integer diseaseId = doc.getDiseaseId();
        Disease disease = diseaseService.getDisease(diseaseId);
        List<Doctor> sameDoc = doctorService.getSameDoc(doc.getDiseaseId());
        Price priceByGuhao = priceService.getPriceByGuhao(dTid);    //拿到挂号价格的信息
        model.addAttribute("docInfo",doc);
        model.addAttribute("disease",disease);
        if(FilterTime.size()!=0){
            model.addAttribute("time",FilterTime);
        }else{
            model.addAttribute("time","暂无排班");
        }
        model.addAttribute("priceByGuhao",priceByGuhao);
        model.addAttribute("sameDoc",sameDoc);
        return "yuyueguahao";
}

    /**
     * 完善阶段
     * @return
     */

    @GetMapping("/user/Info")
    public String PutInfo(String Did,Integer PriceId ,Integer timeId,Model model, HttpSession session){
        model.addAttribute("timeId",timeId);
       model.addAttribute("Did",Did);
       model.addAttribute("PriceId",PriceId);
        Object user = session.getAttribute("user");
        return "consummate";
    }

    /**
     * 获取 用户的信息进行存储完善更新
     * @param Did：医生的id
     * @return
     */
    @PostMapping("/user/save")
        public String SaveInfo(String Did,Integer PriceId,Integer timeId,String phone,String username,String certNo,Model model,HttpSession session){
            System.out.println(Did+"    "+phone+"    "+username+"    "+certNo+"    "+PriceId);
            User user = (User) session.getAttribute("user");
            iUserService.InsertUserInfo(phone,username,certNo,user.getUid());  //进行用户信息的完善
            Doctor doc = doctorService.getDoc(Did);                                //拿到医生的信息
            Price priceByGuhao = priceService.getPriceByGuhao(doc.getTitle().getDTid());//拿到价格的对象从而拿到挂号价格
            System.out.println("价格的id为：" +priceByGuhao.getPriceId());
            Disease disease = diseaseService.getDisease(doc.getDiseaseId());        //拿到医生所治疗的科目
            User userInfo = iUserService.getUserById(user.getUid());
            Time time = timeService.getTime(timeId);
            model.addAttribute("doc",doc);
            model.addAttribute("price",priceByGuhao);
            model.addAttribute("disease",disease);
            model.addAttribute("time",time);
            model.addAttribute("userInfo",userInfo);
            return "OrdingInfo";
        }


    /**
     * 开始生成订单
     * @return
     */
    @PostMapping("/user/Ording")
    public String Ording(RedirectAttributes redirectAttributes, HttpServletRequest req, String DocId, String UserId, Integer TimeId, Integer PriceId, Integer time, String disease, Model model){
        System.out.println(time);  //初诊 复诊
        System.out.println(disease); //疾病描述
        Time time1 = timeService.getTime(TimeId);
        Integer account = time1.getAccount();//得到余数
        if(account>0){
            ordinglistService.AddOrding(UserId,DocId,PriceId,TimeId,time,disease);//提交订单未支付
            //这边需要加入支付
            timeService.cutCount(TimeId);//将预约量减少1
            /*以上需要增加事务管理*/
            HttpSession session=req.getSession();
            User user=(User)session.getAttribute("user");
            int pn=1;
            if(req.getParameter("pn")!=null){
                pn=Integer.parseInt(req.getParameter("pn"));
            }
            System.out.println("pn="+pn);
            com.example.healthcare.bean.PageHelper pageHelper=new com.example.healthcare.bean.PageHelper();
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

        }else {
           redirectAttributes.addFlashAttribute("msg","用户已满");
            return "redirect:/OrdingInfo.html";
        }
        }


        @GetMapping("/user/cancel")
        @ResponseBody
        public Object cancel( Integer ordingId){
            Map<String,Object> map=new HashMap<>();
            System.out.println("订单的id为："+ordingId);
            Ordinglist ording = ordinglistService.getOrding(ordingId);
            Integer timeId = ording.getTime().getTimeId();
            System.out.println("时间表的id为："+timeId);
            ordinglistService.DelOrding(ordingId);
            timeService.AddCount(timeId);
            map.put("msg","取消预约成功");
           // JSONObject result = JSONObject.parseObject(JSON.toJSONString(map.put("msg","取消预约成功")));
            return map;
        }
        /*单线完成*/
//    @Autowired
//    private HttpSession session;

    /* ************ */
    /*启动定时器任务*/
    /*启动定时器任务*/
    @Scheduled(cron = "0 */10 * * * ?")
    public void delOrd(){
        System.out.println("定时器开始对未支付订单开始删除");
        List<Ordinglist> ords = ordinglistService.getUnPayOrd();
        if(ords.size()!=0){
            System.out.println("有未支付的订单");
            for (Ordinglist o:ords){
                ordinglistService.DelOrding( o.getOrdingId());
                timeService.AddCount( o.getTime().getTimeId());
                System.out.println("未支付订单开始删除，医生人数增加人数"+new Date());
            }
        }else{
            System.out.println("无未支付的订购单！！"+new Date());
        }
    }

    @RequestMapping("/user/chat")
    public String chat(){
        return "chat";
    }
    @RequestMapping("/user/chat1")
    public String chat2(){
        return "chat1";
    }
}
