package com.dw.service;

import com.dw.dao.AttrQuery;
import com.dw.dao.TimeQuery;
import org.neo4j.driver.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class QueryService {
    private final AttrQuery attrQuery;
    private final TimeQuery timeQuery;

    public QueryService(AttrQuery attrQuery, TimeQuery timeQuery) {
        this.attrQuery = attrQuery;
        this.timeQuery = timeQuery;
    }

    public HashMap<String, Object> queryByMovieAttr(String data, String queryType){

        List<HashMap<String, String>> ans= new ArrayList<>();
        List<Record> recordList;
        long startTime = System.currentTimeMillis();    //获取开始时间
        switch (queryType) {
            case "title":
            case "Title":
                recordList = attrQuery.queryByTitle(data);
                break;
            case "actor":
            case "Actor":
                recordList = attrQuery.queryByActor(data);
                break;
            case "director":
            case "Director":
                recordList = attrQuery.queryByDirector(data);
                break;
            case "label":
            case "Label":
                recordList = attrQuery.queryByLabel(data);
                break;
            default:
                System.out.println("error");
                return new HashMap<String, Object>();
        }

        long endTime = System.currentTimeMillis();    //获取开始时间
        long time = endTime - startTime;

        for (Record record: recordList) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("product_id", record.get("product_id").toString());
            item.put("score", record.get("score").toString());
            item.put("emotion_score", record.get("emotion_score").toString());
            item.put("title", record.get("title").toString());
            ans.add(item);
        }
        HashMap<String, Object> ret = new HashMap<String, Object>();
        ret.put("time", time);
        ret.put("movieList", ans);
        return ret;
    }

    public HashMap<String, Object> queryByMovieScore(Integer score, String scoreType, String cmp){
        List<HashMap<String, String>> ans= new ArrayList<>();
        List<Record> recordList;
        long startTime = System.currentTimeMillis();    //获取开始时间
        recordList = attrQuery.queryByScore(score, scoreType, cmp);
        long endTime = System.currentTimeMillis();    //获取开始时间
        long time = endTime - startTime;
        for (Record record: recordList) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("product_id", record.get("product_id").toString());
            item.put("score", record.get("score").toString());
            item.put("emotion_score", record.get("emotion_score").toString());
            item.put("title", record.get("title").toString());
            ans.add(item);
        }
        HashMap<String, Object> ret = new HashMap<String, Object>();
        ret.put("time", time);
        ret.put("movieList", ans);
        return ret;
    }

    public HashMap<String, Object> queryByTime(String timeData, String timeType, String cmp){

        List<HashMap<String, String>> ans= new ArrayList<>();
        List<Record> recordList;
        List<String> dataList;
        long startTime;    //获取开始时间
        System.out.println("111");
        switch (timeType){
            case "year":
                startTime = System.currentTimeMillis();
                recordList = timeQuery.queryTimeByYear(timeData, cmp);
                break;
            case "season":
                dataList = Arrays.asList(timeData.split("-"));
                System.out.println(dataList);
                int month = Integer.parseInt(dataList.get(1));
                Integer season;
                if (month<=3){
                    season = 1;
                } else if (month<=6){
                    season = 2;
                } else if (month<=9) {
                    season = 3;
                } else if (month<=12){
                    season = 4;
                } else {
                    System.out.println("error");
                    season = -1;
                }
                startTime = System.currentTimeMillis();
                recordList = timeQuery.queryTimeBySeason(dataList.get(0), season.toString(), cmp);
                break;
            case "month":
                dataList = Arrays.asList(timeData.split("-"));
                startTime = System.currentTimeMillis();
                recordList = timeQuery.queryTimeByMonth(dataList.get(0), dataList.get(1), cmp);
                break;
            case "day":
                dataList = Arrays.asList(timeData.split("-"));
                startTime = System.currentTimeMillis();
                recordList = timeQuery.queryTimeByDay(dataList.get(0), dataList.get(1), dataList.get(2), cmp);
                break;
            default:
                System.out.println("error");
                return new HashMap<>();
        }
        long endTime = System.currentTimeMillis();    //获取开始时间
        long time = endTime - startTime;
        HashMap<String, Object> ret = new HashMap<String, Object>();
        ret.put("time", time);
        ret.put("count", recordList.get(0).get("count").toString());
        return ret;
    }
}
