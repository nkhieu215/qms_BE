package com.fn.qms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.models.PqcWorkOrderPlanning;

@Repository
public interface PlanningWoRepository extends JpaRepository<PqcWorkOrderPlanning, Long> {

	@Query("SELECT t FROM PqcWorkOrder t where 1=1 "
			+ " AND (:productionName is NULL OR t.productionName like %:productionName%) "
			+ " AND (:productionCode is NULL OR t.productionCode like %:productionCode%) "
			+ " AND (:planingWorkOrderCode is NULL OR t.planingWorkOrderCode like %:planingWorkOrderCode%) "
			
			+ " order by t.createdAt desc")
	Page<PqcWorkOrderPlanning> findList(@Param("productionName") String productionName, @Param("productionCode") String productionCode, @Param("planingWorkOrderCode") String planingWorkOrderCode,Pageable pageable);
	
}