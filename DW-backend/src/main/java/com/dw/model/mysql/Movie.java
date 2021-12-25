package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xuedixuedi
 * 电影实体类
 */
@Entity
@Table(name = "movie_schema")
@org.hibernate.annotations.Table(appliesTo = "movie_schema", comment = "电影表")
public class Movie {
    @Id
    private String product_id;

    private String title;
    private int version_count;
    private int day_id;
    private int score;
    private double emotion_score;

}
