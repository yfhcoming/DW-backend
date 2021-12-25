package com.dw.controller.mysql;


import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    DirectorService directorService;
    //查询这个导演的电影列表
    @GetMapping("/find/director/movie")
    public ResultVo finddirectormovie(String directorName,double begin,double end) {
        List<Object> list =directorService.getdirectormovie(directorName,begin,end);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("product_id", String.valueOf(cells[0]));
            temp1.put("title", String.valueOf(cells[1]));
            temp1.put("director", String.valueOf(cells[2]));
            temp1.put("actor", String.valueOf(cells[3]));
            temp1.put("score", String.valueOf(cells[4]));
            temp1.put("emotion_score", String.valueOf(cells[5]));
            temp1.put("label", String.valueOf(cells[6]));
            result.add(temp1);
        }
        return new ResultVo(result,directorService.gettime());
    }
    //查询和给定导演合作的演员
    @GetMapping("/find/director/actor")
    public ResultVo finddirectoractor(String directorName) {
        List<Object> list =directorService.getdirectoractor(directorName);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("name", String.valueOf(cells[0]));
            temp1.put("cooperation", String.valueOf(cells[1]));
            result.add(temp1);
        }
        return new ResultVo(result,directorService.gettimeone());
    }
    //查询和给定导演合作的导演
    @GetMapping("/find/director/director")
    public ResultVo finddirectordirector(String directorName) {
        List<Object> list =directorService.getdirectordirector(directorName);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("name", String.valueOf(cells[0]));
            temp1.put("cooperation", String.valueOf(cells[1]));
            result.add(temp1);
        }
        return new ResultVo(result,directorService.gettimetwo());
    }
}
