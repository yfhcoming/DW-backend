package com.dw.dao;

import org.neo4j.driver.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class AttrQuery implements AutoCloseable{

    private final Driver driver;

    public AttrQuery(String uri, String username, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
    }

    /**
     * ② 按照电影名称进行查询电影
     */
    public List<Record> queryByTitle(final String title){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result = transaction.run("match (a:Movie) where a.title=$title return " +
                                    "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                    "a.title as title limit 200;",
                            parameters("title", title));
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }

    /**
     * ③ 按照导演进行查询电影
     */
    public List<Record> queryByDirector (final String director){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result = transaction.run("match (d:Director)-[]-(a:Movie) where d.director=$director return " +
                                    "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                    "a.title as title limit 200;",
                            parameters("director", director));
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }

    /**
     * ④ 按照演员进行查询电影
     */
    public List<Record>queryByActor (final String actor){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result = transaction.run("match (d:Actor)-[]-(a:Movie) where d.actor=$actor return " +
                                    "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                    "a.title as title limit 200;",
                            parameters("actor", actor));
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }

    /**
     * ⑤ 按照类别进行查询电影
     */
    public List<Record>queryByLabel (final String label){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result = transaction.run("match (d:Label)-[]-(a:Movie) where d.label=$label return " +
                                    "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                    "a.title as title limit 200;",
                            parameters("label", label));
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }


    /**
     * ⑥ 按照评价分数进行查询电影
     * ⑦ 按照情感分数进行查询电影
     * scoreType: score 评价分数 emotion_score 情感分数
     * cmp: 0 相等 1 greater -1 less
     */
    public List<Record> queryByScore (final Integer score, final String scoreType, final String cmp){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp) {
                        case "equal":
                            result = transaction.run("match (a:Movie) where a." + scoreType + "=$score return " +
                                            "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                            "a.title as title limit 200;",
                                    parameters("score", Integer.valueOf(score.toString())));
                            break;
                        case "greater":
                            result = transaction.run("match (a:Movie) where a." + scoreType + ">"+score+" return " +
                                            "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                            "a.title as title limit 200;",
                                    parameters("score", Integer.valueOf(score.toString())));
                            break;
                        case "less":
                            String cmd = "match (a:Movie) where a." + scoreType + "<"+score+" return " +
                                    "a.product_id as product_id, a.score as score, a.emotion_score as emotion_score, " +
                                    "a.title as title limit 200;";
                            result = transaction.run(cmd);
                            break;
                        default:
                            return new ArrayList<Record>();
                    }
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return ans;
        }
    }

//    public HashMap<String, Object> getReviewListByMovie(@RequestParam String title){
//        try(Session session = driver.session()){
//            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
//                @Override
//                public List<Record> execute(Transaction transaction) {
//                    Result result;
//                    result=transaction.run("")
//                    List<Record> resultList = result.list();
//                    System.out.println(resultList);
//                    return resultList;
//                }
//            });
//            return ans;
//        }
//    }


    @Override
    public void close() throws Exception {
        driver.close();
    }
}
