package com.example.healthcare.Service;

import com.example.healthcare.bean.Time;

public interface TimeService {

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
