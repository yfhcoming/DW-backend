package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论实体类
 *
 * @author
 */
@Entity
@Table(name = "review_schema")
@org.hibernate.annotations.Table(appliesTo = "review_schema", comment = "电影评论表")
public class Review {
    @Id
    @GeneratedValue
    private int review_id;

    private String product_id;
    private String user_id;
    private int score;
    private double emotion_score;
    private String time;

}
