package com.example.healthcare.Service;

import com.example.healthcare.bean.Disease;

public interface DiseaseService {

    /**
     * 传入疾病的id找到相应的疾病信息
     * @return
     */
    Disease getDisease(Integer diseaseId);
}
