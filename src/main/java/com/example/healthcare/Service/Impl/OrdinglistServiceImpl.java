package com.example.healthcare.Service.Impl;

import com.example.healthcare.Service.OrdinglistService;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.mapper.OrdinglistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinglistServiceImpl implements OrdinglistService {

    @Autowired
    private OrdinglistMapper ordinglistMapper;

    @Override
    public void AddOrding(String Uid, String Did, Integer PriceId, Integer TimeId,Integer isVisit,String diseaseInfo) {
        ordinglistMapper.AddOrding(Uid,Did,PriceId,TimeId,isVisit,diseaseInfo);
    }

    @Override
    public void DelOrding(Integer OrdingId) {
       ordinglistMapper.DelOrding(OrdingId);
    }

    @Override
    public List<Ordinglist> getOrds(String Uid) {
        return ordinglistMapper.getOrds(Uid);
    }

    @Override
    public List<Ordinglist> getOrdsByPage(String Uid,Integer pn,Integer pageSize) {
        return ordinglistMapper.getOrdsByPage(Uid,(pn-1)*4,pageSize);
    }

    @Override
    public Ordinglist getOrding(Integer OrdingId) {
        return ordinglistMapper.getOrding(OrdingId);
    }

    @Override
    public Integer getTotalOrds(String Uid) {
        return ordinglistMapper.getTotalOrds(Uid);
    }

    @Override
    public List<Ordinglist> getUnPayOrd() {
        return ordinglistMapper.getUnPayOrd();
    }

    @Override
    public void updateIspay(Integer OrdingId) {
        ordinglistMapper.updateIspay(OrdingId);
    }


}
