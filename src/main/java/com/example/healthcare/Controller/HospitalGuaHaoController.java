package com.example.healthcare.Controller;

import com.example.healthcare.Service.*;
import com.example.healthcare.bean.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HospitalGuaHaoController {
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

    @GetMapping("/user/hos")
    public String getHos(String hospitalName, String subjectName, Model model, @RequestParam(value = "pn",defaultValue = "1") Integer pn){
        Hospital hospital = hospitalService.getHosByName(hospitalName, subjectName);
        Integer hospitalId = hospital.getHospitalId();
        Subject info = subjectService.getInfo(subjectName);
        Integer subjectId = info.getSubjectId();
        PageHelper.startPage(pn,4);
        List<Doctor> doctors = doctorService.getDocsByHos(hospitalId,subjectId);
        PageInfo<Doctor> page=new PageInfo<>(doctors,5);
        System.out.println("总的页码为："+page.getPages());
        model.addAttribute("subjectName",subjectName);
        model.addAttribute("pageInfo",page);
        model.addAttribute("hospital",hospital);
        return "hospitalInfo";
    }

    @GetMapping("/user/fen")
    @ResponseBody
    public Object getPage( @RequestParam(value = "pn",defaultValue = "1") Integer pn,String hospitalName, String subjectName){
        System.out.println("---->"+hospitalName);
        System.out.println("---->"+subjectName);
        Hospital hospital = hospitalService.getHosByName(hospitalName, subjectName);
        Integer hospitalId = hospital.getHospitalId();
        Subject info = subjectService.getInfo(subjectName);
        Integer subjectId = info.getSubjectId();

        /*注：pagehelper只执行sql分页*/
        PageHelper.startPage(pn,4);
        List<Doctor> doctors = doctorService.getDocsByHos(hospitalId,subjectId);
        PageInfo<Doctor> page=new PageInfo<>(doctors,5);
        List<Doctor> list = page.getList();
        for(Doctor d:list){
            System.out.println(d);
        }
        return page;
    }


    @GetMapping("/user/second")
    public String DocInfo(String Did,Model model){
        System.out.println(Did);
        Doctor doc = doctorService.getDoc(Did);                 //拿到医生的对象
        List<Time> time = doc.getTime();                         //医生的时间表
        List<Time> FilterTime=new ArrayList<>();
        for (Time t:time) {
            if(t.getAccount()>0){
                FilterTime.add(t);
            }
        }
        Integer dTid = doc.getTitle().getDTid();                   //拿到价格查相应的价格
        Integer diseaseId = doc.getDiseaseId();
        Disease disease = diseaseService.getDisease(diseaseId);
        List<Doctor> sameDoc = doctorService.getSameDoc(diseaseId);//拿到全部的同科室医生2条
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

}
