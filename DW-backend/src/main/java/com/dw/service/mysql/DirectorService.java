package com.dw.service.mysql;

import com.dw.dao.mysql.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;
    private long time=0;
    private long timeone=0;
    private long timetwo=0;

    public List getdirectormovie(String directorName,double begin,double end){
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=directorRepository.getdirectormovie(directorName,begin,end);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }
    public List getdirectoractor(String directorName){
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=directorRepository.getdirectoractor(directorName);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeone = endTime - startTime;
        return list;
    }
    public List getdirectordirector(String directorName){
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=directorRepository.getdirectordirector(directorName);
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
