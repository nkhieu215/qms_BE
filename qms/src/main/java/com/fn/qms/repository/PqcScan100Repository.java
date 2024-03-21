package com.fn.qms.repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.models.PqcScan100;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcScan100Repository extends JpaRepository<PqcScan100, Long> {
    @Query("from PqcScan100 t where t.workOrderId= :woId and t.status =:status")
    List<PqcScan100> getListByWoId(@Param("woId") Long woId,@Param("status") Integer status);
}