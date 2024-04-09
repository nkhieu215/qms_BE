package com.fn.qms.repository;

import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcStoreCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcWorkOrder;

import java.util.Date;
import java.util.List;

@Repository
public interface PqcWorkOrderRepository extends JpaRepository<PqcWorkOrder, Long> {

    @Query("SELECT t FROM PqcWorkOrder t where 1=1 "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:sap is NULL OR t.sapWo like %:sap%) "
            + " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
            + " order by t.createdAt desc")
    Page<PqcWorkOrder> findListByName(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                      @Param("lotNumber") String lot, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("sap") String sap, @Param("woCode") String woCode, Pageable pageable);


    @Query("SELECT t FROM PqcWorkOrder t inner join PqcWorkOrderStepStatus b on t.id = b.pqcWorkOrder where 1=1 "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:sap is NULL OR t.sapWo like %:sap%) "
            + " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
            + " AND (:userId is NULL OR UPPER(b.userId) =UPPER(:userId)) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:step is NULL OR UPPER(b.step) =:step) "
            + " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
            + " order by t.createdAt desc")
    Page<PqcWorkOrder> findListByStep(@Param("productionName") String productionName, @Param("productionCode") String status,
                                      @Param("lotNumber") String lot, @Param("step") String step, @Param("userId") String userId,
                                      @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("sap") String sap, @Param("woCode") String woCode, Pageable pageable);


    @Query("SELECT t FROM PqcWorkOrder t where 1=1 "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
            + " AND t.status in ('APPROVE','WAIT_APPROVE','CREATE','REJECT')"
            + " order by t.createdAt desc")
    List<PqcWorkOrder> report(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("branchName") String branchName, @Param("groupName") String groupName);


    @Query(value = "SELECT SUM(report_error_all.quantity) AS total_err, report_error_all.`production_name`  FROM `report_error_all`  " +
            "WHERE report_error_all.`created_at` BETWEEN :startDate AND :endDate "
            + " AND (:branchName is NULL OR UPPER(report_error_all.branch_name) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(report_error_all.group_name) like %:groupName%) "
            + " GROUP BY report_error_all.`production_name` ORDER BY total_err DESC LIMIT 20", nativeQuery = true)
    List<Object[]> getTotakErrorTop(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("branchName") String branchName, @Param("groupName") String groupName);


    @Query(value = "SELECT SUM(report_error_all.quantity) AS total_err, report_error_all.`err_group`  FROM `report_error_all` " +
            "WHERE report_error_all.`created_at` BETWEEN :startDate AND :endDate "
            + " AND (:branchName is NULL OR UPPER(report_error_all.branch_name) like %:branchName%) "
            + " AND (:groupName is NULL OR UPPER(report_error_all.group_name) like %:groupName%) "
            + " GROUP BY report_error_all.`err_group`", nativeQuery = true)
    List<Object[]> getTotakErrorGroup(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("branchName") String branchName, @Param("groupName") String groupName);
    @Query(value="select count(status) from `pqc_work_order` where status ='WAIT' " +
            "and created_at >=?1 and created_at <=?2 " +
            "and production_code like %?3% and production_name like %?4% " +
            "and branch_name like %?5% and group_name like %?6% ;",nativeQuery = true)
    public Integer countWorkOrderWaitStatus(String startDate, String endDate ,String productCode,String productName,String branchName,String groupName);
    @Query(value="select " +
            "status, " +
            "production_code, " +
            "production_name, " +
            "branch_name, " +
            "group_name " +
            " from `pqc_work_order` where " +
            " created_at >=?1 and created_at <=?2 ",nativeQuery = true)
    public List<Object[]>workOrderWaitStatus(String startDate, String endDate);
}