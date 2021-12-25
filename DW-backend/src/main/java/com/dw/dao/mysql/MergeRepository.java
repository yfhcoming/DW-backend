package com.dw.dao.mysql;

import com.dw.model.mysql.Actor;
import com.dw.model.mysql.Merge;
import com.dw.vo.MergeVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MergeRepository extends CrudRepository<Merge, Long> {


    @Query("select new com.dw.vo.MergeVo(M.p_id,M.merge_pids) from Merge as M where M.p_id in (:pids)")
    List<MergeVo> findMergedMovie(@Param("pids") List<String> pids);

//    @Query(value = "select * from trade$seek_purchase_offer where sp_id in (:spIds) and of_enuu = :enUu", nativeQuery = true)
//    List<SeekPurchaseOffer> getSeekPurchaseOfferList(@Param("spIds") List<Long> spIds, @Param("enUu") Long enUu);
}
