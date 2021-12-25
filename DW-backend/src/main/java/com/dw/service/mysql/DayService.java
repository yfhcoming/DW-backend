package com.dw.service.mysql;


import com.dw.dao.mysql.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {
    @Autowired
    DayRepository dayRepository;
    private long yeartime=0;
    private long monthtime=0;
    private long daytime=0;
    private long seasontime=0;

    public List yearCount(Integer year, String than) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=dayRepository.yearCount(year,than);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.yeartime = endTime - startTime;
        return list;
    }
    public List monthCount(Integer year,Integer month, String than) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list= dayRepository.monthCount(year,month,than);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.monthtime = endTime - startTime;
        return list;
    }
    public List dayCount(Integer year,Integer month,Integer day, String than) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list= dayRepository.dayCount(year,month,day,than);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.daytime = endTime - startTime;
        return list;
    }
    public List seasonCount(Integer year, Integer season) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list= dayRepository.seasonCount(year,season);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.daytime = endTime - startTime;
        return list;
    }

    public long yeartime(){
        return yeartime;
    }
    public long monthtime(){
        return monthtime;
    }
    public long daytime(){
        return daytime;
    }
    public long seasontime(){
        return seasontime;
    }
}
