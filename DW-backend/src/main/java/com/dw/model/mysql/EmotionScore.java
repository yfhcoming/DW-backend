package com.dw.model.mysql;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xuedixuedi
 * 情感分数表
 */
@Data
@Entity
@Table(name = "emotion_score_schema")
@org.hibernate.annotations.Table(appliesTo = "emotion_score_schema", comment = "情感评分表")
public class EmotionScore {

    @Id
    private int emotion_score;

    @Column(nullable = true)
    private int count;

    public int getEmotionScore() {
        return emotion_score;
    }
    public int getCount() {
        return count;
    }
}
