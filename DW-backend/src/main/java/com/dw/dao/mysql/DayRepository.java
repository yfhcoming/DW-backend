package com.dw.dao.mysql;

import com.dw.model.mysql.Time;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository  extends CrudRepository<Time, Long> {
    @Query(value = "call find_movie_by_year(:year, :than);", nativeQuery = true)
    List yearCount(@Param("year") int year, @Param("than") String than);

    @Query(value = "call find_movie_by_month(:year, :month,:than);", nativeQuery = true)
    List monthCount(@Param("year") int year, @Param("month") int month,@Param("than") String than);

    @Query(value = "call find_movie_by_day(:year, :month, :day, :than);", nativeQuery = true)
    List dayCount(@Param("year") int year, @Param("month") int month,@Param("day") int day,@Param("than") String than);

    @Query(value = "find_movie_by_season(:year, :season);", nativeQuery = true)
    List seasonCount(@Param("year") int year,@Param("season") int season);

}
