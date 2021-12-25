package com.dw.controller.mysql;

import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.MovieService;
import com.dw.service.mysql.ReviewService;
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
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieService movieService;


    @GetMapping("/find/movie/review")
    public ResultVo findreview(String title) {
        long startTime = System.currentTimeMillis();
        String id = movieService.getIdByTitle(title);
        List<Object> list =reviewService.getreview(id);
        List<HashMap<String, String>> result = new ArrayList<>();
        for(Object item : list){
            HashMap<String, String> temp1 = new HashMap<>();
            Object[] cells = (Object[]) item;
            temp1.put("title", title);
            temp1.put("profile_name", String.valueOf(cells[0]));
            temp1.put("review_emotion_score", String.valueOf(cells[1]));
            result.add(temp1);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        return new ResultVo(result,time);
    }
}
