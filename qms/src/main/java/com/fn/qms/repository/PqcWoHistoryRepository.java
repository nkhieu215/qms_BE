package com.fn.qms.repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcQualityCheck;
import com.fn.qms.models.PqcWorkOrderApproveHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcWoHistoryRepository extends JpaRepository<PqcWorkOrderApproveHist, Long> {

    @Query("from PqcWorkOrderApproveHist t where t.workOrderId= :woId")
    List<PqcWorkOrderApproveHist> getListByWoId(@Param("woId") Long woId);
}