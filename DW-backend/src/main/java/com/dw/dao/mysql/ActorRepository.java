package com.dw.dao.mysql;

import com.dw.model.mysql.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

    @Query(value = "call find_actor_movie(:actorName,:begin,:end);", nativeQuery = true)
    List getactormovie(@Param("actorName") String actorName,@Param("begin") Double begin,@Param("end") Double end);

    @Query(value = "call find_actor_by_actor(:actorName);", nativeQuery = true)
    List getactor(@Param("actorName") String actorName);

    @Query(value = "call find_director_by_actor(:actorName);", nativeQuery = true)
    List getdirector(@Param("actorName") String actorName);
}
