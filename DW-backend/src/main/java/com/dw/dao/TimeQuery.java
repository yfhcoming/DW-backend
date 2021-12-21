package com.dw.dao;

import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class TimeQuery implements AutoCloseable{

    private final Driver driver;

    public TimeQuery(String uri, String user, String password){
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    /**
     * ① 按照时间进行查询及统计
     * 粒度：年份
     * 某年的电影数
     * cmp: 0 相等 1 after -1 before
     */
    public List<Record> queryTimeByYear(final String year, final String cmp){
        // TODO
        try(Session session = driver.session()){
            List<Record> cnt = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp) {
                        case "equal":
//                            result = transaction.run("match(t:Time) where t.year=$year return sum(t.year_count) as count order by count limit 200;",
//                                    parameters("year", Integer.valueOf(year)));
//                            break;
                            result = transaction.run("match(t:Time) where t.year=$year with distinct t.year as year, t.year_count as year_c return sum(year_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year)));
                            break;
                        case "greater":
                            result = transaction.run("match(t:Time) where t.year>$year with distinct t.year as year, t.year_count as year_c return sum(year_c) as count order by count , count limit 200;",
                                    parameters("year", Integer.valueOf(year)));
                            break;
                        case "less":
                            result = transaction.run("match(t:Time) where t.year<$year with distinct t.year as year, t.year_count as year_c return sum(year_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year)));
                            break;
                        default:
                            return new ArrayList<>();
                    }
                    List<Record> resultList = result.list();
                    System.out.println(resultList);
                    return resultList;
                }
            });
            return cnt;
        }
    }

    /**
     * ① 按照时间进行查询及统计
     * 粒度：季度
     * 某年某季度的电影数
     * cmp: 0 相等 1 after -1 before
     */
    public List<Record> queryTimeBySeason(final String year, final String season, final String cmp){
        try(Session session = driver.session()){
            List<Record> cnt = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp) {
                        case "equal":
//                            result = transaction.run("match(t:Time) where t.year=$year and t.season=$season return t.season_count as count order by count limit 200;",
//                                    parameters("year", Integer.valueOf(year), "season", Integer.valueOf(season)));
//                            break;
                            result = transaction.run("match(t:Time) where t.year=$year and t.season=$season with distinct t.year as year,t.season as season,t.season_count as season_count_c return sum(season_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "season", Integer.valueOf(season)));
                            break;
                        case "greater":
                            result = transaction.run("match(t:Time) where t.year>$year or " +
                                            "(t.year=$year and t.season>$season) with distinct t.year as year,t.season as season,t.season_count as season_count_c return sum(season_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "season", Integer.valueOf(season)));
                            break;
                        case "less":
                            result = transaction.run("match(t:Time) where t.year<$year or " +
                                            "(t.year=$year and t.season<$season) with distinct t.year as year,t.season as season,t.season_count as season_count_c return sum(season_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "season", Integer.valueOf(season)));
                            break;
                        default:
                            return new ArrayList<>();
                    }
                    List<Record> resultList = result.list();
                    return resultList;
                }
            });
            return cnt;
        }
    }

    /**
     * ① 按照时间进行查询及统计
     * 粒度：月份
     * 某年某月的电影数
     * cmp: 0 相等 1 after -1 before
     */
    public List<Record> queryTimeByMonth(final String year, final String month, final String cmp){
        try(Session session = driver.session()){
            List<Record> cnt = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp) {
                        case "equal":
                            result = transaction.run("match(t:Time) where t.year=$year and t.month=$month with distinct t.year as year,t.month as month,t.month_count as month_count_c return sum(month_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month)));
                            break;
                        case "greater":
                            result = transaction.run("match(t:Time) where t.year>$year or " +
                                            "(t.year=$year and t.month>$month) with distinct t.year as year,t.month as month,t.month_count as month_count_c return sum(month_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month)));
                            break;
                        case "less":
                            result = transaction.run("match(t:Time) where t.year<$year or " +
                                            "(t.year=$year and t.month<$month) with distinct t.year as year,t.month as month,t.month_count as month_count_c return sum(month_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month)));
                            break;
                        default:
                            return new ArrayList<Record>();
                    }
                    List<Record> resultList = result.list();
                    return resultList;
                }
            });
            return cnt;
        }
    }

    /**
     * ① 按照时间进行查询及统计
     * 粒度：日
     * 某年某月某日的电影数
     * cmp: 0 相等 1 after -1 before
     */
    public List<Record> queryTimeByDay(final String year, final String month, final String day,final String cmp){
        try(Session session = driver.session()){
            List<Record> cnt = session.readTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction transaction) {
                    Result result;
                    switch (cmp) {
                        case "equal":
                            result = transaction.run("match(t:Time) where t.year=$year and t.month=$month and t.day=day with distinct t.year as year,t.month as month,t.day as day,t.day_count as day_count_c return sum(day_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month), "day", Integer.valueOf(day)));
                            break;
                        case "greater":
                            result = transaction.run("match(t:Time) where t.year>$year or " +
                                            "(t.year=$year and t.month>$month) or" +
                                            "(t.year=$year and t.month=$month and t.day>$day) with distinct t.year as year,t.month as month,t.day as day,t.day_count as day_count_c return sum(day_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month), "day", Integer.valueOf(day)));
                            break;
                        case "less":
                            result = transaction.run("match(t:Time) where t.year<$year or " +
                                            "(t.year=$year and t.month<$month) or" +
                                            "(t.year=$year and t.month=$month and t.day<$day) with distinct t.year as year,t.month as month,t.day as day,t.day_count as day_count_c return sum(day_count_c) as count order by count limit 200;",
                                    parameters("year", Integer.valueOf(year), "month", Integer.valueOf(month), "day", Integer.valueOf(day)));
                            break;
                        default:
                            return new ArrayList<>();
                    }
                    List<Record> resultList = result.list();
                    return resultList;
                }
            });
            return cnt;
        }
    }
}
