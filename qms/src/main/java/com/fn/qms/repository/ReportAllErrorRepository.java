package com.fn.qms.repository;

import com.fn.qms.models.ReportErrorAll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportAllErrorRepository extends JpaRepository<ReportErrorAll, Long> {

    @Query("SELECT t  FROM ReportErrorAll t where 1=1 "
            + " AND (:productionName is NULL OR t.productionName like %:productionName%) "
            + " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
            + " AND (:errGroup is NULL OR t.errGroup like %:errGroup%) "
            + " AND (:errName is NULL OR t.errName like %:errName%) "
            + " AND (:planingWorkOrderCode is NULL OR t.planingWorkOrderCode like %:planingWorkOrderCode%) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate )"
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " order by t.createdAt desc")
    Page<ReportErrorAll> reportError(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                        @Param("errGroup") String errGroup, @Param("errName") String errName, @Param("planingWorkOrderCode") String woCode,
                                        @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query(value = "SELECT t.id AS id, " +
            "    t.work_order_id AS workOrderId, " +
            "    t.production_code AS productionCode, " +
            "    t.planing_work_order_code AS planingWorkOrderCode, " +
            "    t.purchase_order_code AS purchaseOrderCode, " +
            "    t.bom_version AS bomVersion,     " +
            "    t.created_at AS createdAt, " +
            "    t.updated_at AS updatedAt, " +
            "    t.created_by AS createdBy, " +
            "    t.production_name AS productionName, " +
            "    t.lot_number AS lotNumber, " +
            "    t.quantity_plan AS quantityPlan, " +
            "    t.group_name AS groupName, " +
            "    t.branch_name AS branchName, " +
            "    t.profile_name AS profileName, " +
            "    t.profile_code AS profileCode, " +
            "    t.sap_wo AS sapWo,   " +
            "    t.doc_url AS doc_url," +
            "    t.doc_url2 AS doc_url2, " +
            "    t.start_time AS startTime, " +
            "    t.end_time AS endTime, " +
            "    t.dt AS dt, " +
            "    t.date_create as dateCreate, " +
            "    t.err_group as errGroup, " +
            "    t.err_name as errName, " +
            "    t.quantity as quantity, " +
            "    t.ratio as ratio, " +
            "    t.dttd_type as dttdType, " +
            "    t.serial_no as serialNo, " +
            "    t.process_name as processName " +
            "FROM report_error_all t where 1=1 "
            + " AND (:productionName is NULL OR t.production_name like %:productionName%) "
            + " AND (:productionCode is NULL OR t.production_code like %:productionCode%) "
            + " AND (:errGroup is NULL OR t.err_group like %:errGroup%) "
            + " AND (:errName is NULL OR t.err_name like %:errName%) "
            + " AND (:planingWorkOrderCode is NULL OR t.planing_work_order_code like %:planingWorkOrderCode%) "
            + " AND (:groupName is NULL OR t.group_name like %:groupName%) "
            + " AND (:branchName is NULL OR t.branch_name like %:branchName%) "
            + " AND (:startDate is NULL OR t.created_at >= :startDate )"
            + " AND (:endDate is NULL OR t.created_at <= :endDate) "
            + " order by t.created_at desc",

            countQuery = "SELECT count(t.id) " +
            "FROM report_error_all t where 1=1 "
            + " AND (:productionName is NULL OR t.production_name like %:productionName%) "
            + " AND (:productionCode is NULL OR t.production_code like %:productionCode%) "
            + " AND (:errGroup is NULL OR t.err_group like %:errGroup%) "
            + " AND (:errName is NULL OR t.err_name like %:errName%) "
            + " AND (:planingWorkOrderCode is NULL OR t.planing_work_order_code like %:planingWorkOrderCode%) "
            + " AND (:groupName is NULL OR t.group_name like %:groupName%) "
            + " AND (:branchName is NULL OR t.branch_name like %:branchName%) "
            + " AND (:startDate is NULL OR t.created_at >= :startDate )"
            + " AND (:endDate is NULL OR t.created_at <= :endDate) "
            + " order by t.created_at desc",nativeQuery = true)
    Page<Object[]> reportErrorNative(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                     @Param("errGroup") String errGroup, @Param("errName") String errName, @Param("planingWorkOrderCode") String woCode,
                                     @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("groupName") String groupName, @Param("branchName") String branchName, Pageable pageable);


    @Query(value = "SELECT t.id AS id, " +
            "    t.work_order_id AS workOrderId, " +
            "    t.production_code AS productionCode, " +
            "    t.planing_work_order_code AS planingWorkOrderCode, " +
            "    t.purchase_order_code AS purchaseOrderCode, " +
            "    t.bom_version AS bomVersion,     " +
            "    t.created_at AS createdAt, " +
            "    t.updated_at AS updatedAt, " +
            "    t.created_by AS createdBy, " +
            "    t.production_name AS productionName, " +
            "    t.lot_number AS lotNumber, " +
            "    t.quantity_plan AS quantityPlan, " +
            "    t.group_name AS groupName, " +
            "    t.branch_name AS branchName, " +
            "    t.profile_name AS profileName, " +
            "    t.profile_code AS profileCode, " +
            "    t.sap_wo AS sapWo,   " +
            "    t.doc_url AS doc_url," +
            "    t.doc_url2 AS doc_url2, " +
            "    t.start_time AS startTime, " +
            "    t.end_time AS endTime, " +
            "    t.dt AS dt, " +
            "    t.date_create as dateCreate, " +
            "    t.err_group as errGroup, " +
            "    t.err_name as errName, " +
            "    t.quantity as quantity, " +
            "    t.ratio as ratio, " +
            "    t.dttd_type as dttdType, " +
            "    t.serial_no as serialNo, " +
            "    t.process_name as processName " +
            "FROM report_error_all t where 1=1 "
            + " AND (:productionName is NULL OR t.production_name like %:productionName%) "
            + " AND (:productionCode is NULL OR t.production_code like %:productionCode%) "
            + " AND (:errGroup is NULL OR t.err_group like %:errGroup%) "
            + " AND (:errName is NULL OR t.err_name like %:errName%) "
            + " AND (:planingWorkOrderCode is NULL OR t.planing_work_order_code like %:planingWorkOrderCode%) "
            + " AND (:startDate is NULL OR t.created_at >= :startDate )"
            + " AND (:endDate is NULL OR t.created_at <= :endDate) "
            + " order by t.created_at desc", nativeQuery = true)
    List<Object[]> reportAllError(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
                                        @Param("errGroup") String errGroup, @Param("errName") String errName, @Param("planingWorkOrderCode") String woCode,
                                        @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}