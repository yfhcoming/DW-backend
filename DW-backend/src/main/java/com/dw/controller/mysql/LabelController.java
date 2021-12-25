package com.dw.controller.mysql;



import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.LabelService;
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
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;
    @GetMapping("/get/label/movie")
    public ResultVo getlabelmovie(String label,double begin,double end){
        List<Object> list =labelService.getlabelmovie(label,begin,end);
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
        return new ResultVo(result,labelService.gettime());
    }
}
