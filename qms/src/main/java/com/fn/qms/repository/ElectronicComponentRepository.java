package com.fn.qms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcElectronicComponent;

@Repository
public interface ElectronicComponentRepository extends JpaRepository<IqcElectronicComponent, Long> {

    @Query("SELECT t FROM IqcElectronicComponent t where"
            + " t.status in :status "
            + " AND (:type is NULL OR t.type=:type) "
            + " AND (:userId is NULL OR t.createBy=:userId)"
            + " AND (:aproveBy is NULL OR t.aproveBy=:aproveBy)"
            + " AND (:name is NULL OR t.electCompName like %:name%) order by t.createdAt desc")
    Page<IqcElectronicComponent> findListByName(@Param("name") String name, @Param("status") List<String> status,
                                                @Param("userId") String userId, @Param("aproveBy") String aproveBy, @Param("type") String type,
                                                Pageable pageable);


    @Query("SELECT t FROM IqcElectronicComponent t where 1=1"
            + " AND t.status in :status "
            + " AND (:type is NULL OR t.type=:type) "
            + " AND (:userId is NULL OR t.createBy=:userId)"
            + " AND (:name is NULL OR t.electCompName like %:name%) "
            + " AND (:elecCompCode is NULL OR t.elecCompCode like %:elecCompCode%) "
            + " AND (:reportCode is NULL OR t.reportCode like %:reportCode%) "
            + " AND (:invoiceNumber is NULL OR t.invoiceNumber like %:invoiceNumber%) "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate) "
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + " AND (:itemType is NULL OR t.itemType like %:itemType%) "

            + "order by t.createdAt desc")
    Page<IqcElectronicComponent> findIqc(
                                         @Param("type") String type,
                                         @Param("userId") String userId,

                                         @Param("name") String name,
                                         @Param("elecCompCode") String elecCompCode,
                                         @Param("reportCode") String reportCode,
                                         @Param("invoiceNumber") String invoiceNumber,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate,
                                         @Param("status") List<String> status,
                                         @Param("itemType") String itemType,
                                         Pageable pageable);

    @Query("SELECT t FROM IqcElectronicComponent t where 1=1"
            + " AND t.status in :status "
            + " AND (:startDate is NULL OR t.createdAt >= :startDate) "
            + " AND (:endDate is NULL OR t.createdAt <= :endDate) "
            + "order by t.createdAt desc")
    List<IqcElectronicComponent> findIqcReport(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("status") List<String> status);

    @Query(value = "SELECT SUM(iqc_electronic_component.`po_quantity`),iqc_electronic_component.`status` " +
            "FROM `iqc_electronic_component` WHERE 1=1 "
            + " AND status in :status "
            + " AND (:startDate is NULL OR created_at >= :startDate) "
            + " AND (:endDate is NULL OR created_at <= :endDate) "
            + " GROUP BY STATUS", nativeQuery = true)
    List<Object[]> reportByStatus(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("status") List<String> status);


    @Query(value = "SELECT  origin FROM `iqc_electronic_component` WHERE origin IS NOT NULL AND origin != '' "
            + " AND (:startDate is NULL OR created_at >= :startDate) "
            + " AND (:endDate is NULL OR created_at <= :endDate) "
            + " GROUP BY origin", nativeQuery = true)
    List<Object[]> reportByOrigin(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "SELECT COUNT(`iqc_electronic_component`.`status`)," +
            "CASE  " +
            " WHEN STATUS = 'APPROVE' THEN \"Đạt \" " +
            " WHEN STATUS = 'CONCESSIONS' THEN \"Nhân nhượng\" " +
            " WHEN STATUS = 'REJECT' THEN \"Không đạt\" " +
            " ELSE \"Khác\"  " +
            " END AS STATUS"
            + " FROM iqc_electronic_component WHERE STATUS IN ('APPROVE','CONCESSIONS','REJECT') "
            + " AND (:startDate is NULL OR iqc_electronic_component.created_at >= :startDate) "
            + " AND (:endDate is NULL OR iqc_electronic_component.created_at <= :endDate) "
            + "  GROUP  BY iqc_electronic_component.`status`", nativeQuery = true)
    List<Object[]> reportCountStatus(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    @Query(value = "SELECT  origin,po_quantity,status,checking_quantity FROM `iqc_electronic_component` ",nativeQuery = true)
    public List<Object[]> getListIqcElectronicComponentByConditions();
    @Query(value="select count(status) from `iqc_electronic_component` where status ='WAIT_APPROVE'",nativeQuery = true)
    public Integer countIqcWaitApproveStatus();
}