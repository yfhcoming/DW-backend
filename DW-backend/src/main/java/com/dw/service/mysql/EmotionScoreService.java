package com.dw.service.mysql;


import com.dw.dao.mysql.EmotionScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmotionScoreService {
    @Autowired
    EmotionScoreRepository emotionScoreRepository;
    private long time=0;

    public List getemotionscoremovie(Integer emotionscore, String than) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=emotionScoreRepository.getemotionscoremovie(emotionscore,than);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }
    public long gettime(){
        return time;
    }
}
