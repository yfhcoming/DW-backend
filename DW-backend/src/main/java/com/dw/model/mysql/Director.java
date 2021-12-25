package com.dw.model.mysql;

import com.dw.model.mysql.pk.DirectorPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author xuedixuedi
 * 导演实体类
 */
@Entity
@Table(name = "director_schema")
@org.hibernate.annotations.Table(appliesTo = "director_schema", comment = "导演表")
public class Director {

    @EmbeddedId
    private DirectorPK id;

    @Column(nullable = true)
    private Integer count;

}
