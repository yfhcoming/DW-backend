package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xuedixuedi
 * 电影评分实体类
 */
@Entity
@Table(name = "score_schema")
@org.hibernate.annotations.Table(appliesTo = "score_schema", comment = "电影评分表")
public class Score {

    @Id
    @GeneratedValue
    private int score;

    private int count;

    public int getScore() {
        return score;
    }

    public int getCount() {
        return count;
    }


}
