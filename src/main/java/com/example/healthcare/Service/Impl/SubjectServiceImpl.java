package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.SubjectService;
import com.example.healthcare.bean.Subject;
import com.example.healthcare.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    @Cacheable(cacheNames = "dis")
    public Subject getDiseases(String Subject) {
        return subjectMapper.getDiseases(Subject);
    }

    @Override
    @Cacheable(cacheNames = "dis")
    public Subject getSub(Integer SubjectId) {
        return subjectMapper.getSub(SubjectId);
    }

    @Override
    @Cacheable(cacheNames = "dis")
    public Subject getInfo(String SubjctName) {
        return subjectMapper.getInfo(SubjctName);
    }
}
