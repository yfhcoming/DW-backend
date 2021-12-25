package com.dw.model.mysql;

import com.dw.model.mysql.pk.LabelPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 电影标签实体类
 *
 * @author xuedixuedi
 */
@Entity
@Table(name = "label_schema")
@org.hibernate.annotations.Table(appliesTo = "label_schema", comment = "电影标签表")
public class Label {

    @EmbeddedId
    private LabelPK id;

    private int count;

    public int getMovieCount() {
        return count;
    }

}
