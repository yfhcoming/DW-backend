package com.dw.controller.mysql;

import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.ActorService;
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
@RequestMapping("actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    //查询给定演员的电影列表
    @GetMapping("/find/actor/movie")
    public ResultVo findactormovie(String actorName,double begin,double end) {
        List<Object> list =actorService.getactormovie(actorName,begin,end);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("title", String.valueOf(cells[0]));
            temp1.put("director", String.valueOf(cells[1]));
            temp1.put("actor", String.valueOf(cells[2]));
            temp1.put("score", String.valueOf(cells[3]));
            temp1.put("emotion_score", String.valueOf(cells[4]));
            temp1.put("label", String.valueOf(cells[5]));
            result.add(temp1);
        }
        return new ResultVo(result,actorService.gettime());
    }
    //查询和给定演员合作的演员
    @GetMapping ("/find/actor")
    public ResultVo findactor(String actorName) {
        List<Object> list =actorService.getactor(actorName);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("name", String.valueOf(cells[0]));
            temp1.put("cooperation", String.valueOf(cells[1]));
            result.add(temp1);
        }
        return new ResultVo(actorService.getactor(actorName),actorService.gettimeone());
    }
    //查询和给定演员合作的导演
    @GetMapping ("/find/director")
    public ResultVo finddirector(String actorName) {
        List<Object> list =actorService.getdirector(actorName);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("name", String.valueOf(cells[0]));
            temp1.put("cooperation", String.valueOf(cells[1]));
            result.add(temp1);
        }
        return new ResultVo(result,actorService.gettimetwo());
    }
}
