package com.example.healthcare.mapper;

import com.example.healthcare.bean.Time;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TimeMapper {

    /**
     * 根据时间表的id拿时间的信息
     * @param timeId
     * @return
     */
    Time getTime(Integer timeId);

    /**
     * 预约成功后需要将剩余人数减一
     * @param TimeId
     * @return
     */
    void cutCount(Integer TimeId);

    /**
     * 取消预约时将剩余人数加一
     * @param TimeId
     * @return
     */
    void AddCount(Integer TimeId);
}
