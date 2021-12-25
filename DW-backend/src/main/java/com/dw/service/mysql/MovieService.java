package com.dw.service.mysql;


import com.dw.dao.mysql.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private long time;
    private long timeone=0;
    private long timetwo=0;
    private long timethree=0;
    private long timefour=0;
    private long timefive=0;
    private long timesix=0;
    private long timeseven=0;
    private long timeeight=0;
    private long timenine=0;
    private long timeten=0;
    private long timeele=0;

    public List<Object> getmoviebytitle(String title) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List<Object> list=movieRepository.getmoviebytitle(title);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }
    public List getmoviebyfour(String movie,String director,String actor,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebyfour(movie,director,actor,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeone = endTime - startTime;
        return list;
    }
    public List getmoviebytitledirector(String movie,String director) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebytitledirector(movie,director);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timetwo = endTime - startTime;
        return list;
    }
    public List getmoviebytitleactor(String movie,String actor) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebytitleactor(movie,actor);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timethree = endTime - startTime;
        return list;
    }
    public List getmoviebytitlelabel(String movie,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebytitlelabel(movie,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timefour = endTime - startTime;
        return list;
    }
    public List getmoviebydirectoractor(String director,String actor) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebydirectoractor(director,actor);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timefive = endTime - startTime;
        return list;
    }
    public List getmoviebydirectorlabel(String director,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebydirectorlabel(director,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timesix = endTime - startTime;
        return list;
    }
    public List getmoviebyactorlabel(String actor,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebyactorlabel(actor,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeseven = endTime - startTime;
        return list;
    }
    public List getmoviebynolabel(String movie,String director,String actor){
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebynolabel(movie,director,actor);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeeight = endTime - startTime;
        return list;
    }
    public  List getmoviebynoactor(String movie,String director,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebynoactor(movie,director,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timenine = endTime - startTime;
        return list;
    }
    public List getmoviebynodirector(String movie,String actor,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebynodirector(movie,actor,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeten = endTime - startTime;
        return list;
    }
    public List getmoviebynotitle(String director,String actor,String label) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list=movieRepository.getmoviebynotitle(director,actor,label);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.timeele = endTime - startTime;
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
    public long gettimethree(){
        return timethree;
    }
    public long gettimefour(){
        return timefour;
    }
    public long gettimefive(){
        return timefive;
    }
    public long gettimesix(){return timesix;}
    public long gettimeseven(){return timeseven;}
    public long gettimeeight(){
        return timeeight;
    }
    public long gettimenine(){
        return timenine;
    }
    public long gettimeten(){
        return timeten;
    }
    public long gettimeele(){
        return timeele;
    }
}
