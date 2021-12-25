package com.dw.service.mysql;


import com.dw.dao.mysql.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    LabelRepository labelRepository;
    private long time=0;

    public List getlabelmovie(String label,double begin,double end){
        long startTime = System.currentTimeMillis();    //获取开始时间
        List list= labelRepository.getlabelmovie(label,begin,end);
        long endTime = System.currentTimeMillis();    //获取结束时间
        this.time = endTime - startTime;
        return list;
    }
    public long gettime(){
        return time;
    }
}

