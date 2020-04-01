package com.example.healthcare.mapper;

import com.example.healthcare.bean.Ordinglist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrdinglistMapper {

    /**
     * 生成订单
     * @return
     */
    void AddOrding(@Param("Uid") String Uid,@Param("Did") String Did,@Param("PriceId") Integer PriceId,@Param("TimeId") Integer TimeId,@Param("isVisit") Integer isVisit,@Param("diseaseInfo") String diseaseInfo);

    /**
     * 取消订单
     * @return 根据订单的id对订单进行取消
     * 注：同时医生时间表的预约人数增加一
     */
    void DelOrding(@Param("OrdingId") Integer OrdingId);

    /**
     * 根据用户的id得到用户的所有的挂号单
     * @param Uid
     * @return
     */
    List<Ordinglist> getOrds(String Uid);

    List<Ordinglist> getOrdsByPage(String Uid,Integer pn,Integer pageSize);

    /**
     * 根据ordingId拿到ordinglist的对象
     */
    Ordinglist getOrding(@Param("OrdingId") Integer OrdingId);

    void updateIspay(@Param("OrdingId")Integer OrdingId);

    public Integer getTotalOrds(@Param("Uid") String Uid);

    /*定时器取消订单*/
    List<Ordinglist> getUnPayOrd();


}
