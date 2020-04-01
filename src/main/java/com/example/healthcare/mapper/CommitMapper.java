package com.example.healthcare.mapper;


import com.example.healthcare.bean.Commit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@Component
public interface CommitMapper {
    public void addCommit1(Commit commit);

    public void addCommit2(Commit commit);

    public List<Commit> selectTuwen(String Uid);

    public List<Commit> selectJisu(String Uid);

    public void deleteCommit(Integer CommitId);
}
