package com.dw.controller;

import com.dw.dao.AttrQuery;
import com.dw.dao.TimeQuery;
import com.dw.service.QueryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/query", produces = {MediaType.APPLICATION_JSON_VALUE})
public class QueryController {

    final private QueryService queryService = new QueryService(
            new AttrQuery("bolt://localhost:7687", "neo4j", "dw"),
            new TimeQuery("bolt://localhost:7687", "neo4j", "dw")
    );


    @ResponseBody
    @RequestMapping(value = "/neo4j/title", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByTitle(@RequestParam String title){
        return queryService.queryByMovieAttr(title, "title");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/actor", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByActor(@RequestParam String actor){
        return queryService.queryByMovieAttr(actor, "Actor");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/director", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByDirector(@RequestParam String director){
        return queryService.queryByMovieAttr(director, "Director");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/label", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByLabel(@RequestParam String label){
        return queryService.queryByMovieAttr(label, "Label");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/score", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByScore(@RequestParam Integer score, @RequestParam String comparison){
        return queryService.queryByMovieScore(score,"score", comparison );
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/emotion", method = RequestMethod.GET)
    public HashMap<String, Object> getMovieListByEmotion(@RequestParam Integer emotion, @RequestParam String comparison){
        return queryService.queryByMovieScore(emotion,"emotion_score", comparison );
    }
}
