package com.dw.dao;

import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class StatisticsQuery implements AutoCloseable{

    private final Driver driver;

    public StatisticsQuery(String uri, String user, String password){
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public List<Record> statisticScore(final String scoreType){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
//                    if (scoreType.equals("score")){
//                        result = transaction.run("match (a:Movie) return distinct a.score as score," +
//                                " a.score_count as count order by score,count desc limit 200;");
//                    } else if (scoreType.equals("emotion_score")) {
//                        result = transaction.run("match (a:Movie) return distinct a.emotion_score as score," +
//                                " a.emotion_count as count order by score,count desc limit 200;");
//                    } else {
//                        return new ArrayList<>();
//                    }
                    if (scoreType.equals("score")){
                        result = transaction.run("match (a:Movie) return distinct a.score as score," +
                                " a.score_count as count order by count limit 200;");
                    } else if (scoreType.equals("emotion_score")) {
                        result = transaction.run("match (a:Movie) return distinct a.emotion_score as score," +
                                " a.emotion_count as count order by count limit 200;");
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

    public List<Record> getCountByScore(final Integer score, final String scoreType, final String cmp){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp){
                        case "equal":
                            if (scoreType.equals("score")){
                                result = transaction.run("match (a:Movie) where a.score=$score " +
                                                "return a.score_count as count order by count limit 200;",
                                        parameters("score", score));
                            } else if (scoreType.equals("emotion_score")) {
                                result = transaction.run("match (a:Movie) where a.emotion_score=$score " +
                                                "return a.emotion_count as count order by count limit 200;",
                                        parameters("score", score));
                            } else {
                                return new ArrayList<>();
                            }
                            break;
                        case "greater":
                            if (scoreType.equals("score")){
                                result = transaction.run("match (a:Movie) where a.score>$score " +
                                                "return distinct a.score as score, a.score_count as count order by count desc limit 200;",
                                        parameters("score", score));
                            } else if (scoreType.equals("emotion_score")) {
                                result = transaction.run("match (a:Movie) where a.emotion_score>$score " +
                                                "return distinct a.emotion_score as score,a.emotion_count as count order by count desc limit 200;",
                                        parameters("score", score));
                            } else {
                                return new ArrayList<>();
                            }
                            break;
                        case "less":
                            if (scoreType.equals("score")){
                                result = transaction.run("match (a:Movie) where a.score<$score " +
                                                "return distinct a.score as score,a.score_count as count order by count limit 200;",
                                        parameters("score", score));
                            } else if (scoreType.equals("emotion_score")) {
                                result = transaction.run("match (a:Movie) where a.emotion_score<$score " +
                                                "return distinct a.emotion_score as score,a.emotion_count as count order by count limit 200;",
                                        parameters("score", score));
                            } else {
                                return new ArrayList<>();
                            }
                            break;
                        default:
                            System.out.println("error");
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

    public List<Record> getCountByType(final String data, final String nodeLabel){
        try(Session session = driver.session()){
            List<Record> ans = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (nodeLabel) {
                        case "Actor":
                        case "actor":
                            result = transaction.run("match (a:Actor) where a.actor=$data " +
                                            "return a.count as count;",
                                    parameters("data", data));
                            break;
                        case "Director":
                        case "director":
                            result = transaction.run("match (a:Director) where a.director=$data " +
                                            "return a.count as count;",
                                    parameters("data", data));
                            break;
                        case "Label":
                        case "label":
                            result = transaction.run("match (a:Label) where a.label=$data " +
                                            "return a.count as count;",
                                    parameters("data", data));
                            break;
                        default:
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
