package com.example.healthcare.Service;

import com.example.healthcare.bean.Commit;
import com.example.healthcare.mapper.CommitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitService {
    @Autowired
    private CommitMapper commitMapper;

    public void addCommit1(Commit commit){
        commitMapper.addCommit1(commit);
    }

    public void addCommit2(Commit commit){
        commitMapper.addCommit2(commit);
    }

    public List<Commit> selectTuwen(String Uid){
        return commitMapper.selectTuwen(Uid);
    }

    public List<Commit> selectJisu(String Uid){
        return commitMapper.selectJisu(Uid);
    }

    public void deleteCommit(Integer CommitId){
        commitMapper.deleteCommit(CommitId);
    }
}
