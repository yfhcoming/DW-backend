package com.dw.model.mysql;

import com.dw.model.mysql.pk.ActorPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 演员实体类：演员与演员参演的电影
 *
 * @author xuedixuedi
 */
@Entity
@Table(name = "actor_schema")
@org.hibernate.annotations.Table(appliesTo = "actor_schema", comment = "演员参演电影表")
public class Actor {

    @EmbeddedId
    private ActorPK id;
    private int count;

}
