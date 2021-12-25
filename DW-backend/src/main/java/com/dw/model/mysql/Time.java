package com.dw.model.mysql;

import javax.persistence.*;

/**
 * @author xuedixuedi
 * 时间实体类
 */
@Entity
@Table(name = "day_schema")
@org.hibernate.annotations.Table(appliesTo = "day_schema", comment = "日期表")
public class Time {

    @Id
    @GeneratedValue
    private int day_id;

    @Column(nullable = true)
    private int year;

    @Column(nullable = true)
    private int month;

    @Column(nullable = true)
    private int day;

    @Column(nullable = true)
    private int season;

    private int year_count;

    private int month_count;

    private int day_count;

    private int season_count;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getSeason() {
        return season;
    }

    public int getYear() {
        return year;
    }
}
