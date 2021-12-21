package com.dw.dao;

import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class RelationQuery implements AutoCloseable{

    private final Driver driver;

    public RelationQuery(String uri, String username, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    /**
     * ⑧⑨⑩(11) 按照演员（演员）和导演（演员）的关系进行查询及统计
     * 查询和某个演员合作最多的导演
     * @param: startName: 起始点名称 startLabel: 起始节点类别 endLabel: 结束点类别
     * @return: List<Record> , Record 包括 导演名和合作次数
     */
    public List<Record> findRelationAD(final String startName, final String startLabel, final String endLabel){
        try(Session session = driver.session()) {
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    if(startLabel.equals("Actor") && endLabel.equals("Actor")){
                        result = transaction.run("match (d:Actor)-[:act_movie]->(:Movie)<-[:act_movie]-(a:Actor) where d.actor=$data return a.actor as name limit 200;",
                                parameters("data", startName));
                    } else if (startLabel.equals("Actor") && endLabel.equals("Director")){
                        result = transaction.run("match (d:Actor)-[:act_movie]->(:Movie)<-[:director_movie]-(D:Director) where d.actor=$data return D.director as name limit 200;",
                                parameters("data", startName));
                    } else if (startLabel.equals("Director") && endLabel.equals("Actor")){
                        result = transaction.run("match (a:Actor)-[:act_movie]->(:Movie)<-[:director_movie]-(d:Director) where d.director=$data return a.actor as name limit 200;",
                                parameters("data", startName));
                    } else if (startLabel.equals("Director") && endLabel.equals("Director")){
                        result = transaction.run("match (d:Director)-[:director_movie]->(:Movie)<-[:director_movie]-(D:Director) where d.director=$data return D.director as name limit 200;",
                                parameters("data", startName));
                    } else {
                        return new ArrayList<>();
                    }
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }
}
