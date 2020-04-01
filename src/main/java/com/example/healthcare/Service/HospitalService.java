package com.example.healthcare.Service;

import com.example.healthcare.bean.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalService {
    /**
     * 根据市查出相映的医院
     * @return
     */
    List<Hospital> getHospital(String city);
    /**
     * 根据医院的名称查询出医院信息
     */
    Hospital getHosByName(@Param("hospitalName") String hospitalName);

    /**
     * 根据医院的id查出医院的信息
     * @param HospitalId
     * @return
     */
    Hospital getInfo(Integer HospitalId);
    /**
     * 拿到医院的名称或id查出医院的科目
     * @param
     * @return
     */
    List<Hospital> getHospitalSub(@Param("HospitalName")String HospitalName);

    /**
     *医生表加医院表根据医院id查出所有医生
     */
    Hospital getDocInfo(Integer HospitalId,Integer SubjectId,Integer diseaseId);

    /**
     * 根据医院名称和科目得到医生的所有信息
     * @param HospitalName
     * @param Subject
     * @return
     */
    Hospital getHosByName(@Param("HospitalName") String HospitalName,@Param("Subject") String Subject);
}
