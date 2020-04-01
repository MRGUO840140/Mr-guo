package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.DiseaseService;
import com.example.healthcare.bean.Disease;
import com.example.healthcare.mapper.DiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseMapper diseaseMapper;

    @Override
    public Disease getDisease(Integer diseaseId) {
        return diseaseMapper.getDisease(diseaseId);
    }
}
