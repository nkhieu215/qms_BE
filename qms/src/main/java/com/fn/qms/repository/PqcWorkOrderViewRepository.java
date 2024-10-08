package com.fn.qms.repository;

import com.fn.qms.models.PqcWorkOrderView;
import com.fn.qms.models.PqcWorkOrderViewStep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PqcWorkOrderViewRepository extends JpaRepository<PqcWorkOrderView, Long> {

    @Query("SELECT t FROM PqcWorkOrderView t where 1=1 "
            + " AND (:status is NULL OR t.status like %:status%) "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:sap is NULL OR t.sapWo like %:sap%) "

            + " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
            + " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
            + " AND (:workOrderId is NULL OR UPPER(t.workOrderId) like %:workOrderId%) "
            + " order by t.createdAt desc")
    Page<PqcWorkOrderView> findListByName(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                          @Param("lotNumber") String lot, @Param("startDate") Date startDate, @Param("endDate") Date endDate,
                                          @Param("sap") String sap, @Param("woCode") String woCode, @Param("status") String status, @Param("groupName") String groupName, @Param("branchName") String branchName,@Param("workOrderId") String workOrderId, Pageable pageable);


}