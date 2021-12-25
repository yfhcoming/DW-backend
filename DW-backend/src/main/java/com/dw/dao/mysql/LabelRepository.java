package com.dw.dao.mysql;

import com.dw.model.mysql.Label;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
    @Query(value = "call find_label_movie(:label,:begin,:end);", nativeQuery = true)
    List getlabelmovie(@Param("label") String label,@Param("begin") Double begin,@Param("end") Double end);


}
