package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.HospitalService;
import com.example.healthcare.bean.Hospital;
import com.example.healthcare.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    //@Cacheable(cacheNames = "hos")
    public List<Hospital> getHospital(String city) {
        return hospitalMapper.getHospital(city);
    }

    @Override
    public Hospital getHosByName(String hospitalName) {
        return hospitalMapper.getHosByName(hospitalName);
    }

    @Override
    public Hospital getInfo(Integer HospitalId) {
        return hospitalMapper.getInfo(HospitalId);
    }

    @Override
    //@Cacheable(cacheNames = "hos")
    public List<Hospital> getHospitalSub(String HospitalName) {
        return hospitalMapper.getHospitalSub(HospitalName);
    }

    @Override
    public Hospital getDocInfo(Integer HospitalId, Integer SubjectId,Integer diseaseId) {
        return hospitalMapper.getDocInfo(HospitalId,SubjectId, diseaseId);
    }

    @Override
    public Hospital getHosByName(String HospitalName, String Subject) {
        return hospitalMapper.getHosByName(HospitalName,Subject);
    }
}
