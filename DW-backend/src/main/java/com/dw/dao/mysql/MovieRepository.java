package com.dw.dao.mysql;

import com.dw.model.mysql.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query(value = "call find_movie_by_title(:title);", nativeQuery = true)
    List<Object> getmoviebytitle(@Param("title") String title);
    @Query(value = "call find_movie_by_fourall(:movie,:director,:actor,:label);", nativeQuery = true)
    List<Object> getmoviebyfour(@Param("movie") String movie,@Param("director") String director,@Param("actor") String actor,@Param("label") String label);
    @Query(value = "call find_movie_by_title_director(:movie,:director);", nativeQuery = true)
    List getmoviebytitledirector(@Param("movie") String movie,@Param("director") String director);
    @Query(value = "call find_movie_by_title_actor(:movie,:actor);", nativeQuery = true)
    List getmoviebytitleactor(@Param("movie") String movie,@Param("actor") String actor);
    @Query(value = "call find_movie_by_title_label(:movie,:label);", nativeQuery = true)
    List getmoviebytitlelabel(@Param("movie") String movie,@Param("label") String label);
    @Query(value = "call find_movie_by_director_actor(:director,:actor);", nativeQuery = true)
    List getmoviebydirectoractor(@Param("director") String director,@Param("actor") String actor);
    @Query(value = "call find_movie_by_director_label(:director,:label);", nativeQuery = true)
    List getmoviebydirectorlabel(@Param("director") String director,@Param("label") String label);
    @Query(value = "call find_movie_by_actor_label(:actor,:label);", nativeQuery = true)
    List getmoviebyactorlabel(@Param("actor") String actor,@Param("label") String label);
    @Query(value = "call find_movie_by_notitle(:director,:actor,:label);", nativeQuery = true)
    List getmoviebynotitle(@Param("director") String director,@Param("actor") String actor,@Param("label") String label);
    @Query(value = "call find_movie_by_nolabel(:movie,:director,:actor);", nativeQuery = true)
    List getmoviebynolabel(@Param("movie") String movie,@Param("director") String director,@Param("actor") String actor);
    @Query(value = "call find_movie_by_noactor(:movie,:director,:label);", nativeQuery = true)
    List getmoviebynoactor(@Param("movie") String movie,@Param("director") String director,@Param("label") String label);
    @Query(value = "call find_movie_by_no_director(:movie,:actor,:label);", nativeQuery = true)
    List getmoviebynodirector(@Param("movie") String movie,@Param("actor") String actor,@Param("label") String label);

}
