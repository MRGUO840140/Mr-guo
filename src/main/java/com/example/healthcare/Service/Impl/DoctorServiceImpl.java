package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.DoctorService;
import com.example.healthcare.bean.Doctor;
import com.example.healthcare.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public Doctor getDoc(String Did) {
        return doctorMapper.getDoc(Did);
    }

    @Override
    public List<Doctor> getDocsByHos(Integer hospitalId, Integer subjectId) {
        return doctorMapper.getDocsByHos(hospitalId,subjectId);
    }

    @Override
    public List<Doctor> getSameDoc(Integer diseaseId) {
        return doctorMapper.getSameDoc(diseaseId);
    }

    @Override
    public List<Doctor> findDoctorById(Integer subjectId) {
        return doctorMapper.findDoctorById(subjectId);
    }

    @Override
    public List<Doctor> selectByPages(Integer SubjectId,Integer TitleId,Integer HospitalId,Integer pn, Integer pageSize) {
        return doctorMapper.selectByPages(SubjectId,TitleId,HospitalId,(pn-1)*4,pageSize);
    }

    @Override
    public Integer selectTotalPages(Integer subjectId,Integer TitleId,Integer HospitalId) {
        return doctorMapper.selectTotalPages(subjectId,TitleId,HospitalId);
    }

    /*李思玉部分*/
    @Override
    public List<Doctor> findAllDoctor() {
        return doctorMapper.findAllDoctor();
    }

    @Override
    public List<Doctor> findDoctorByLevel(Integer level) {
        return doctorMapper.findDoctorByLevel(level);
    }

    @Override
    public List<Doctor> findDoctorByMaleDisease(Integer maleDiseaseId) {
        return doctorMapper.findDoctorByMaleDisease(maleDiseaseId);
    }

}
