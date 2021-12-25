package com.dw.dao.mysql;

import com.dw.model.mysql.EmotionScore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmotionScoreRepository extends CrudRepository<EmotionScore, Long> {
    @Query(value = "call find_movie_by_emotion_score(:emotionscore, :than);", nativeQuery = true)
    List getemotionscoremovie(@Param("emotionscore") int emotionscore, @Param("than") String than);

}
