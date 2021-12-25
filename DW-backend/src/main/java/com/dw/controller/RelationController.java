package com.dw.controller;

import com.dw.dao.RelationQuery;
import com.dw.framework.ResultVo;
import com.dw.service.RelationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/relationships", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RelationController {

    final private RelationService relationService = new RelationService(
            new RelationQuery("bolt://localhost:7687", "neo4j", "dw")
    );

    @ResponseBody
    @RequestMapping(value = "/neo4j/actor-actor", method = RequestMethod.GET)
    public ResultVo getActorByActorInNeo4j(String actorName) {
        return this.relationService.findRelationAD(actorName, "Actor","Actor");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/director-actor", method = RequestMethod.GET)
    public ResultVo getActorByDirectorInNeo4j(String directorName) {
        return this.relationService.findRelationAD(directorName, "Director","Actor");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/director-director", method = RequestMethod.GET)
    public ResultVo getDirectorByDirectorInNeo4j(String directorName) {
        return this.relationService.findRelationAD(directorName, "Director","Director");
    }

    @ResponseBody
    @RequestMapping(value = "/neo4j/actor-director", method = RequestMethod.GET)
    public ResultVo getDirectorByActorInNeo4j(String actorName) {
        return this.relationService.findRelationAD(actorName, "Actor","Director");
    }
}
