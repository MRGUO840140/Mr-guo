package com.example.healthcare.Controller;

import com.example.healthcare.Service.DoctorService;
import com.example.healthcare.bean.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/user/doctors")
    @ResponseBody
    public Map<String,Object> findAllDoctor() {
        List<Doctor> doctors=doctorService.findAllDoctor();
        Map<String,Object> map=new HashMap<>();
        if(doctors!=null) {
            map.put("msg", "success");
            map.put("doctors",doctors);
        }else{
            map.put("msg","failed");
        }
        return map;
    }

    @RequestMapping("/findDoctorByLevel")
    @ResponseBody
    public List<Doctor> findDoctorByLevel(Integer level) {
        return doctorService.findDoctorByLevel(level);
    }

    @RequestMapping("/findDoctorByMaleDisease")
    @ResponseBody
    public Map<String ,Object> findDoctorByMaleDisease(Integer maleDiseaseId) {
        List<Doctor> doctors=doctorService.findDoctorByMaleDisease(maleDiseaseId);
        Map<String,Object> map=new HashMap<>();
        if(doctors!=null) {
            map.put("msg", "success");
            map.put("doctors",doctors);
        }else{
            map.put("msg","failed");
        }
        return map;
    }
}
