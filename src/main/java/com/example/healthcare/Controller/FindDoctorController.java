package com.example.healthcare.Controller;

import com.example.healthcare.Service.DoctorService;
import com.example.healthcare.Service.PriceService;
import com.example.healthcare.bean.Doctor;
import com.example.healthcare.bean.PageHelper;
import com.example.healthcare.bean.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class FindDoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PriceService priceService;

    @GetMapping("/findDoctors")
    public String findDoctors(Integer subjectId, Integer TitleId, Integer HospitalId,String SubjectName, HttpServletRequest req){
        //System.out.println(subjectId);
        HttpSession session=req.getSession();
        /*List<Doctor> doctors=doctorService.findDoctorById(subjectId);
        session.setAttribute("doctors",doctors);*/
        int pn=1;
        if(req.getParameter("pn")!=null){
            pn=Integer.parseInt(req.getParameter("pn"));
        }
        PageHelper pageHelper=new PageHelper();
        pageHelper.setCurrentPage(pn);
        int pageSize=4;
        pageHelper.setPageSize(pageSize);
        List<Doctor> doctors=doctorService.selectByPages(subjectId,TitleId,HospitalId,SubjectName,pn,pageSize);
        pageHelper.setListItems(doctors);
        int totalPages=doctorService.selectTotalPages(subjectId,TitleId,HospitalId);
        pageHelper.setTotalPages(totalPages);
        int pageCount=(totalPages%pageSize==0?(totalPages/pageSize):(totalPages/pageSize+1));
        pageHelper.setPageCount(pageCount);
        session.setAttribute("pageHelper",pageHelper);
        session.setAttribute("subjectId",subjectId);
        session.setAttribute("HospitalId",HospitalId);
        return "registration";
    }



    @GetMapping("/tuwen")
    public  String tuwen(String Did,HttpSession session){
        Doctor doctor=doctorService.getDoc(Did);
        session.setAttribute("Doctor",doctor);
        Price priceByTuwen=priceService.getPriceByTuwen(doctor.getTitle().getDTid());
        session.setAttribute("priceByTuwen",priceByTuwen);
        session.setAttribute("Did",Did);
        return "tuwenzixun";
    }
}