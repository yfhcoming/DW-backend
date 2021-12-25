package com.dw.dao.mysql;

import com.dw.model.mysql.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
    @Query(value = "call find_movie_by_score(:score, :than);", nativeQuery = true)
    List getscoremovie(@Param("score") int score, @Param("than") String than);
}
