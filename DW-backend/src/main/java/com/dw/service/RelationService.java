package com.dw.service;

import com.dw.dao.RelationQuery;
import com.dw.framework.ResultVo;
import org.neo4j.driver.Record;

import java.util.*;

public class RelationService {

    private final RelationQuery relationQuery;

    public RelationService(RelationQuery relationQuery){
        this.relationQuery = relationQuery;
    }

    public ResultVo findRelationAD(final String startName, final String startLabel, final String endLabel){

//        List<HashMap<String, String>> ans= new ArrayList<>();

        long startTime = System.currentTimeMillis();    //获取开始时间
        List<Record> recordList = relationQuery.findRelationAD(startName, startLabel, endLabel);
        long endTime = System.currentTimeMillis();    //获取开始时间
        long time = endTime - startTime;

        HashMap<String, Integer> items = new HashMap<String, Integer>();
        ArrayList<String> names = new ArrayList<>();

        for (Record record: recordList) {
            names.add(record.get("name").toString());
        }
        for (String name:names){
            if(items.containsKey(name)){
                continue;
            }
            items.put(name, Collections.frequency(names,name));
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(items.entrySet()); //将map的entryset放入list集合
        //对list进行排序，并通过Comparator传入自定义的排序规则
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue(); //重写排序规则，小于0表示升序，大于0表示降序
            }
        });
        //用迭代器对list中的键值对元素进行遍历
        Iterator<Map.Entry<String, Integer>> iter = list.iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> item = iter.next();
            String key = item.getKey();
            int value = item.getValue();
            System.out.println("键"+key+"值"+value);
        }

        ResultVo resultVo = new ResultVo(time, list);
        System.out.println(resultVo);
        return resultVo;
    }
}
