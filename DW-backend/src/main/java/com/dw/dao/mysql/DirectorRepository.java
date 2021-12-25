package com.dw.dao.mysql;

import com.dw.model.mysql.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    @Query(value = "call find_director_movie(:directorName);", nativeQuery = true)
    List getdirectormovie(@Param("directorName") String directorName);

    @Query(value = "call find_actor_by_director(:directorName);", nativeQuery = true)
    List getdirectoractor(@Param("directorName") String directorName);

    @Query(value = "call find_director_by_director(:directorName);", nativeQuery = true)
    List getdirectordirector(@Param("directorName") String directorName);

}
