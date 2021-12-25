package com.dw.controller.mysql;


import com.dw.model.mysql.ResultVo;
import com.dw.service.mysql.MovieService;
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
@RequestMapping("movie")
public class movieController {

    @Autowired
    private MovieService movieService;

    //根据电影名称进行查询
    @GetMapping("/find/movie/bytitle")
    public ResultVo findmoviebytitle(String title,double begin,double end) {
        List<Object> list =movieService.getmoviebytitle(title,begin,end);
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
        return new ResultVo(result,movieService.gettime());
    }
    //根据电影名称、导演名称、演员名称和label选择电影列表
    @GetMapping("/find/movie/byfour")
    public ResultVo findmoviebyfour(String movie,String director,String actor,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebyfour(movie,director,actor,label,begin,end);
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
        return new ResultVo(result,movieService.gettimeone());
    }
    //根据电影名称、导演名称选择电影列表
    @GetMapping("/find/movie/bytitledirector")
    public ResultVo findmoviebytitledirector(String movie,String director,double begin,double end) {
        List<Object> list =movieService.getmoviebytitledirector(movie,director,begin,end);
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
        return new ResultVo(result,movieService.gettimetwo());
    }
    //根据电影名称、演员名称选择电影列表
    @GetMapping("/find/movie/bytitleactor")
    public ResultVo findmoviebytitleactor(String movie,String actor,double begin,double end) {
        List<Object> list =movieService.getmoviebytitleactor(movie,actor,begin,end);
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
        return new ResultVo(result,movieService.gettimethree());
    }
    //根据电影名称和label选择电影列表
    @GetMapping("/find/movie/bytitlelabel")
    public ResultVo findmoviebytitlelabel(String movie,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebytitlelabel(movie,label,begin,end);
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
        return new ResultVo(result,movieService.gettimefour());
    }
    //根据电影导演名称、演员名称选择电影列表
    @GetMapping("/find/movie/bydirectoractor")
    public ResultVo findmoviebydirectoractor(String director,String actor,double begin,double end) {
        List<Object> list =movieService.getmoviebydirectoractor(director,actor,begin,end);
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
        return new ResultVo(result,movieService.gettimefive());
    }
    //根据电影导演名称、label选择电影列表
    @GetMapping("/find/movie/bydirectorlabel")
    public ResultVo findmoviebydirectorlabel(String director,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebydirectorlabel(director,label,begin,end);
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
        return new ResultVo(result,movieService.gettimesix());
    }
    //根据电影演员名称和label选择电影列表
    @GetMapping("/find/movie/byactorlabel")
    public ResultVo findmoviebyactorlabel(String actor,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebyactorlabel(actor,label,begin,end);
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
        return new ResultVo(result,movieService.gettimeseven());
    }
    //根据电影名称、导演名称、演员名称选择电影列表
    @GetMapping("/find/movie/bynolabel")
    public ResultVo findmoviebynolabel(String movie,String director,String actor,double begin,double end) {
        List<Object> list =movieService.getmoviebynolabel(movie,director,actor,begin,end);
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
        return new ResultVo(result,movieService.gettimeeight());
    }
    //根据电影名称、导演名称、label选择电影列表
    @GetMapping("/find/movie/bynoactor")
    public ResultVo findmoviebynoactor(String movie,String director,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebynoactor(movie,director,label,begin,end);
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
        return new ResultVo(result,movieService.gettimenine());
    }
    //根据电影名称、演员名称和label选择电影列表
    @GetMapping("/find/movie/bynodirector")
    public ResultVo findmoviebynodirector(String movie,String actor,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebynodirector(movie,actor,label,begin,end);
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
        return new ResultVo(result,movieService.gettimeten());
    }
    //根据电影导演名称、演员名称和label选择电影列表
    @GetMapping("/find/movie/bynotitle")
    public ResultVo findmoviebynotitle(String director,String actor,String label,double begin,double end) {
        List<Object> list =movieService.getmoviebynotitle(director,actor,label,begin,end);
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
        return new ResultVo(result,movieService.gettimeele());
    }
}
