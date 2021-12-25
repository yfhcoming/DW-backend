package com.dw.dao.mysql;

import com.dw.model.mysql.Movie;
import com.dw.model.mysql.ResultVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query(value = "call find_movie_by_title(:title,:begin,:end);", nativeQuery = true)
    List<Object> getmoviebytitle(@Param("title") String title,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_fourall(:movie,:director,:actor,:label,:begin,:end);", nativeQuery = true)
    List<Object> getmoviebyfour(@Param("movie") String movie,@Param("director") String director,@Param("actor") String actor,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_title_director(:movie,:director,:begin,:end);", nativeQuery = true)
    List getmoviebytitledirector(@Param("movie") String movie,@Param("director") String director,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_title_actor(:movie,:actor,:begin,:end);", nativeQuery = true)
    List getmoviebytitleactor(@Param("movie") String movie,@Param("actor") String actor,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_title_label(:movie,:label,:begin,:end);", nativeQuery = true)
    List getmoviebytitlelabel(@Param("movie") String movie,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_director_actor(:director,:actor,:begin,:end);", nativeQuery = true)
    List getmoviebydirectoractor(@Param("director") String director,@Param("actor") String actor,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_director_label(:director,:label,:begin,:end);", nativeQuery = true)
    List getmoviebydirectorlabel(@Param("director") String director,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_actor_label(:actor,:label,:begin,:end);", nativeQuery = true)
    List getmoviebyactorlabel(@Param("actor") String actor,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_notitle(:director,:actor,:label,:begin,:end);", nativeQuery = true)
    List getmoviebynotitle(@Param("director") String director,@Param("actor") String actor,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_nolabel(:movie,:director,:actor,:begin,:end);", nativeQuery = true)
    List getmoviebynolabel(@Param("movie") String movie,@Param("director") String director,@Param("actor") String actor,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_noactor(:movie,:director,:label,:begin,:end);", nativeQuery = true)
    List getmoviebynoactor(@Param("movie") String movie,@Param("director") String director,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);
    @Query(value = "call find_movie_by_no_director(:movie,:actor,:label,:begin,:end);", nativeQuery = true)
    List getmoviebynodirector(@Param("movie") String movie,@Param("actor") String actor,@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);

    @Query("select se.product_id from Movie se where se.title=:tit")
    String getIdByTitle(@Param("tit") String tit);

}
