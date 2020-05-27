package com.example.healthcare.mapper;

import com.example.healthcare.bean.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName:
 * @Author Mr GuoQing
 * @Date: 2020/4/17 20:50
 * @Description:
 */
@Mapper
@Component
public interface DiscussMapper {

    List<Discuss> selectAll();

    Discuss selectById(@Param("id") Long id);
}
