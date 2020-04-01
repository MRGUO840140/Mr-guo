package com.example.healthcare.mapper;

import com.example.healthcare.bean.Disease;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DiseaseMapper {

    /**
     * 传入疾病的id找到相应的疾病信息
     * @return
     */
    Disease getDisease(Integer diseaseId);


}
