package com.fn.qms.repository;

import com.fn.qms.models.PqcQualityCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcWorkOrder;

import java.util.List;

@Repository
public interface PqcBomWorkOrderRepository extends JpaRepository<PqcBomWorkorder, Long> {
    @Query("from PqcBomWorkorder t where t.workOrderId= :woId")
    List<PqcBomWorkorder> getListByWoId(@Param("woId") Long woId);
}