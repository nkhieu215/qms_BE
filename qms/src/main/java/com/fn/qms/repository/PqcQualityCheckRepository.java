package com.fn.qms.repository;

import com.fn.qms.models.PqcStoreConfused;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQualityCheck;

import java.util.List;

@Repository
public interface PqcQualityCheckRepository extends JpaRepository<PqcQualityCheck, Long> {
    @Query("from PqcQualityCheck t where t.workOrderId= :woId")
    List<PqcQualityCheck> getListByWoId(@Param("woId") Long woId);

    @Query("from PqcQualityCheck t where t.qualityId= :qualityId")
    List<PqcQualityCheck> getListByCheckId(@Param("qualityId") Long qualityId);

    @Query(value = "SELECT SUM(`quantity`), `conclude` FROM `pqc_quality_check` WHERE `work_order_id` IN :lstWoId GROUP BY `conclude`", nativeQuery = true)
    List<Object[]> reportCheckQuality(@Param("lstWoId") List<Long> lstWoId);
}