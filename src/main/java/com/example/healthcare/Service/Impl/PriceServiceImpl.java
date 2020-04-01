package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.PriceService;
import com.example.healthcare.bean.Price;
import com.example.healthcare.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public Price getPriceByGuhao(Integer DTid) {
        return priceMapper.getPriceByGuhao(DTid);
    }

    @Override
    public Price getPriceByTuwen(Integer DTid) {
        return priceMapper.getPriceByTuwen(DTid);
    }

    @Override
    public Price getPriceByChat(Integer DTid) {
        return priceMapper.getPriceByChat(DTid);
    }

    @Override
    public Price getPriceByFast(Integer DTid) {
        return priceMapper.getPriceByFast(DTid);
    }
}
