package com.dw.service.mysql;

import com.dw.dao.mysql.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;
    private long time=0;
    private long timeone=0;
    private long timetwo=0;

    public List getactormovie(String actorName) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=actorRepository.getactormovie(actorName);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }

    public List getactor(String actorName) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=actorRepository.getactor(actorName);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeone = endTime - startTime;
        return list;
    }

    public List getdirector(String actorName) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=actorRepository.getdirector(actorName);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timetwo = endTime - startTime;
        return list;
    }
    public long gettime(){
        return time;
    }
    public long gettimeone(){
        return timeone;
    }
    public long gettimetwo(){
        return timetwo;
    }
}
