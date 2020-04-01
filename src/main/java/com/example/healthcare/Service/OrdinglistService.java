package com.example.healthcare.Service;

import com.example.healthcare.bean.Ordinglist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdinglistService {

    /**
     * 生成订单
     * @return
     */
    void AddOrding(String Uid,String Did,Integer PriceId,Integer TimeId,Integer isVisit,String diseaseInfo);

    /**
     * 取消订单
     * @return 根据订单的id对订单进行取消
     * 注：同时医生时间表的预约人数增加一
     */
    void DelOrding(Integer OrdingId);

    /**
     * 根据用户的id得到用户的所有的挂号单
     * @param Uid
     * @return
     */
    List<Ordinglist> getOrds(String Uid);

    List<Ordinglist> getOrdsByPage(String Uid,Integer pn,Integer pageSize);


    void updateIspay(@Param("OrdingId")Integer OrdingId);
    /**
     * 根据ordingId拿到ordinglist的对象
     */
    Ordinglist getOrding(@Param("OrdingId")Integer OrdingId);

    public Integer getTotalOrds(@Param("Uid") String Uid);

    /*定时器取消订单*/
    List<Ordinglist> getUnPayOrd();
}
