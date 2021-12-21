package com.dw.controller;

import com.dw.dao.AttrQuery;
import com.dw.dao.StatisticsQuery;
import com.dw.dao.TimeQuery;
import com.dw.service.StatisticsService;
import com.dw.service.QueryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/statistics", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StatisticsController {

    final private QueryService queryService = new QueryService(
            new AttrQuery("bolt://localhost:7687", "neo4j", "dw"),
            new TimeQuery("bolt://localhost:7687", "neo4j", "dw")
    );

    final private StatisticsService statisticsService = new StatisticsService(
            new StatisticsQuery("bolt://localhost:7687", "neo4j", "dw")
    );

    @ResponseBody
    @RequestMapping(value = "/neo4j/time", method = RequestMethod.GET)
    public HashMap<String, Object> getCountByTimeInNeo4j(@RequestParam String time, @RequestParam String type, @RequestParam String comparison) {
        return queryService.queryByTime(time, type, comparison);
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/score-all", method = RequestMethod.GET)
    public HashMap<String, Object> statisticsScoreInNeo4j() {
        return statisticsService.statisticScore("score");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/emotion-all", method = RequestMethod.GET)
    public HashMap<String, Object> statisticsEmotionScoreInNeo4j() {
        return statisticsService.statisticScore("emotion_score");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/score", method = RequestMethod.GET)
    public HashMap<String, Object> getScoreCountInNeo4j(@RequestParam Integer score, @RequestParam String comparison) {
        return statisticsService.getCountByScore(score,"score",comparison);
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/emotion", method = RequestMethod.GET)
    public HashMap<String, Object> getEmotionScoreCountInNeo4j(@RequestParam Integer score, @RequestParam String comparison) {
        return statisticsService.getCountByScore(score,"emotion_score",comparison);
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/actor-all", method = RequestMethod.GET)
    public HashMap<String, Object> getActorCountInNeo4j(@RequestParam String actor) {
        return statisticsService.getCountByType(actor, "actor");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/director-all", method = RequestMethod.GET)
    public HashMap<String, Object> getDirectorCountInNeo4j(@RequestParam String director) {
        return statisticsService.getCountByType(director, "director");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/label-all", method = RequestMethod.GET)
    public HashMap<String, Object> getLabelCountInNeo4j(@RequestParam String label) {
        return statisticsService.getCountByType(label, "label");
    }
}
