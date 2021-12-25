package com.dw.dao.mysql;

import com.dw.model.mysql.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    @Query(value = "call find_review(:id);", nativeQuery = true)
    List getreview(@Param("id") String id);
}
