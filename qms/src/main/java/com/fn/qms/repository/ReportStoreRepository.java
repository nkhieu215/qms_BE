package com.fn.qms.repository;

import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.models.ReportStoreView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportStoreRepository extends JpaRepository<ReportStoreView, Long> {

	@Query("SELECT t FROM ReportStoreView t where 1=1 "
			+ " AND (:productionName is NULL OR t.productionName like %:productionName%) "
			+ " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
			+ " AND (:sap is NULL OR t.sapWo like %:sap%) "
			+ " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
			+ " AND (:startDate is NULL OR t.createdAt >= :startDate )"
			+ " AND (:endDate is NULL OR t.createdAt <= :endDate) "
			+ " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
			+ " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
			+ " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
			+ " order by t.createdAt desc")
	Page<ReportStoreView> findListByName(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
									  @Param("lotNumber") String lot, @Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("sap") String sap, @Param("woCode") String woCode
			, @Param("branchName") String branchName, @Param("groupName") String groupName, Pageable pageable);



	@Query("SELECT t FROM ReportStoreView t where 1=1 "
			+ " AND (:productionName is NULL OR t.productionName like %:productionName%) "
			+ " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
			+ " AND (:sap is NULL OR t.sapWo like %:sap%) "
			+ " AND (:lotNumber is NULL OR UPPER(t.lotNumber) =:lotNumber) "
			+ " AND (:startDate is NULL OR t.createdAt >= :startDate )"
			+ " AND (:endDate is NULL OR t.createdAt <= :endDate) "
			+ " AND (:branchName is NULL OR UPPER(t.branchName) like %:branchName%) "
			+ " AND (:groupName is NULL OR UPPER(t.groupName) like %:groupName%) "
			+ " AND (:woCode is NULL OR UPPER(t.planingWorkOrderCode) like %:woCode%) "
			+ " order by t.createdAt desc")
	List<ReportStoreView> reportStore(@Param("productionName") String productionName, @Param("productionCode") String productionCode,
								 @Param("lotNumber") String lot, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("sap") String sap, @Param("woCode") String woCode
			, @Param("branchName") String branchName, @Param("groupName") String groupName);

}