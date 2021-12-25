package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 *
 * @author xuedixuedi
 */
@Entity
@Table(name = "user_schema")
@org.hibernate.annotations.Table(appliesTo = "user_schema", comment = "用户表")
public class User {
    @Id
    @GeneratedValue
    private String user_id;

    private String profile_name;

    public String getUserId() {
        return user_id;
    }

    public String getProfileName() {
        return profile_name;
    }

}
