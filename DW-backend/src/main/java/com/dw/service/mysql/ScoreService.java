package com.dw.service.mysql;


import com.dw.dao.mysql.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    private long time=0;
    //查询某个分数的电影数
    public List getscoremovie(Integer score, String than) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=scoreRepository.getscoremovie(score,than);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }
    public long gettime(){
        return time;
    }
}
