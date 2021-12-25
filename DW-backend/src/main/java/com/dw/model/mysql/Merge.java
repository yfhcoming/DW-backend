package com.dw.model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xuedixuedi
 * 电影实体类
 */
@Entity
@Table(name = "merge_schema")
@org.hibernate.annotations.Table(appliesTo = "merge_schema", comment = "电影血缘表")
public class Merge {
    @Id
    private String p_id;

    private String merge_pids;
}
