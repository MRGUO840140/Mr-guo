package com.example.healthcare.mapper;

import com.example.healthcare.bean.Doctor;
import com.example.healthcare.bean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface SubjectMapper {


    /**
     * 更据科目的名称查出其下的疾病信息
     */
    Subject getDiseases(@Param("Subject") String Subject);

    /**
     * 根据科目的id查到当前科目
     */
    Subject getSub(Integer SubjectId);

    /**
     * 根据科目的名称查找到科目的信息
     */
    Subject getInfo(String Subject);

}
