package com.fn.qms.repository;

import com.fn.qms.models.PqcWorkOrderViewStep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PqcWorkOrderStepViewRepository extends JpaRepository<PqcWorkOrderViewStep, Long> {

    @Query("SELECT t FROM PqcWorkOrderViewStep t where 1=1 "
            + " AND (:status is NULL OR t.status =:status) "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:sap is NULL OR t.sapWo like %:sap%) "
            + " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
            + " AND (:userId is NULL OR UPPER(t.userId) =UPPER(:userId)) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
            + " AND (:step is NULL OR UPPER(t.step) =:step) "
            + " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
            + " AND (:workOrderId is NULL OR UPPER(t.workOrderId) like %:workOrderId%) "
            + " order by t.createdAt desc")
    Page<PqcWorkOrderViewStep> findListByStep(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                              @Param("lotNumber") String lot, @Param("step") String step, @Param("userId") String userId,
                                              @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("sap") String sap,
                                              @Param("woCode") String woCode, @Param("status") String status,
                                              @Param("groupName") String groupName, @Param("branchName") String branchName, @Param("workOrderId") String workOrderId,
                                              Pageable pageable);
    @Query("SELECT t FROM PqcWorkOrderViewStep t where 1=1 "
            + " AND t.id =:woId "
            + " AND  UPPER(t.userId) =UPPER(:userId) "
            + " AND t.step = :step "
            + " order by t.createdAt desc")
    List<PqcWorkOrderViewStep> findStepByUserAndWo(@Param("woId") Long woId, @Param("userId") String userId,@Param("step") String step);

}