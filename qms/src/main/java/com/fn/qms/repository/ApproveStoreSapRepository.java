package com.fn.qms.repository;

import com.fn.qms.models.ApproveStoreSap;
import com.fn.qms.models.PqcWorkOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ApproveStoreSapRepository extends JpaRepository<ApproveStoreSap, Long> {

    @Query("SELECT t FROM ApproveStoreSap t  where 1=1 "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:sap is NULL OR t.sapWo like %:sap%) "
            + " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
            + " AND t .statusApproveSap  = UPPER('WAIT_APPROVE') "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
            + " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
            + " order by t.createdAt desc")
    Page<ApproveStoreSap> findStoreSapApprove(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                           @Param("lotNumber") String lot, @Param("startDate") Date startDate, @Param("endDate") Date endDate,
										   @Param("sap") String sap, @Param("woCode") String woCode, @Param("groupName") String groupName,
										   @Param("branchName") String branchName, Pageable pageable);


}