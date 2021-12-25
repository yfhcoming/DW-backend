package com.dw.controller.mysql;


import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.EmotionScoreService;
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
@RequestMapping("/emotionscore")
public class EmotionScoreController {
    @Autowired
    EmotionScoreService emotionScoreService;

    @GetMapping("/find/emotionscore/movie")
    public ResultVo findemotionscoremovie(Integer emotionscore, String than) {
        List<Object> list =emotionScoreService.getemotionscoremovie(emotionscore,than);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("product_id", String.valueOf(cells[0]));
            temp1.put("score", String.valueOf(cells[1]));
            temp1.put("emotion_score", String.valueOf(cells[2]));
            temp1.put("day_id", String.valueOf(cells[3]));
            temp1.put("title", String.valueOf(cells[4]));
            temp1.put("version_count", String.valueOf(cells[5]));
            result.add(temp1);
        }
        return new ResultVo(result,emotionScoreService.gettime());
    }
}
