package com.example.healthcare.mapper;

import com.example.healthcare.bean.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DoctorMapper {
    /**
     * 更据相应的医院查出对应的医生
     */
    List<Doctor> getAllDoc(Integer hospital);

    /**
     * 根据医生的id得到医生的时间表
     */
    Doctor getDoc(@Param("Did")String Did);

    /**
     * 根据医院名称查到对应的所有医生
     */
    List<Doctor> getDocsByHos(@Param("HospitalId") Integer HospitalId,@Param("SubjectId") Integer SubjectId);

    /**
     * 找到同科室的医生
     */
    List<Doctor>  getSameDoc(@Param("diseaseId") Integer diseaseId);

    public List<Doctor> findDoctorById(Integer subjectId);

    public List<Doctor> selectByPages(Integer SubjectId,Integer TitleId,Integer HospitalId,String SubjectName,Integer pn,Integer pageSize);

    public Integer selectTotalPages(Integer SubjectId,Integer TitleId,Integer HospitalId);

    /*李思玉部分*/
    public List<Doctor> findAllDoctor();

    public List<Doctor> findDoctorByLevel(Integer level);

    public List<Doctor> findDoctorByMaleDisease(Integer maleDiseaseId);
}
