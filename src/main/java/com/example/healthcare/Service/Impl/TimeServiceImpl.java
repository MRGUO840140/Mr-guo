package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.TimeService;
import com.example.healthcare.bean.Time;
import com.example.healthcare.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeMapper timeMapper;

    @Override
    public Time getTime(Integer timeId) {
        return timeMapper.getTime(timeId);
    }

    @Override
    public void cutCount(Integer TimeId) {
       timeMapper.cutCount(TimeId);
    }

    @Override
    public void AddCount(Integer TimeId) {
        timeMapper.AddCount(TimeId);
    }
}
