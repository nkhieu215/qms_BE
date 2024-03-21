package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcWorkOrderStepStatus;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PqcWorkOrderStepStatusRepository extends JpaRepository<PqcWorkOrderStepStatus, Long> {


	@Query("SELECT t FROM PqcWorkOrderStepStatus t where 1=1 "
			+ " AND (:pqcWorkOrder is NULL OR t.pqcWorkOrder=:pqcWorkOrder) "
			+ " AND (:userId is NULL OR t.userId =:userId) "
			+ " AND (:step is NULL OR t.step =:step) "
			+ " order by t.createdAt desc")
	List<PqcWorkOrderStepStatus> getStepbyUserId(@Param("pqcWorkOrder") Long pqcWorkOrder, @Param("step") String step, @Param("userId") String status);

	@Query("SELECT t FROM PqcWorkOrderStepStatus t where 1=1 "
			+ " AND  t.pqcWorkOrder=:pqcWorkOrder order by t.position asc")
	List<PqcWorkOrderStepStatus> getStepCheckByWo(@Param("pqcWorkOrder") Long pqcWorkOrder);

	@Query("SELECT t.status FROM PqcWorkOrderStepStatus t where 1=1 "
			+ " AND  t.pqcWorkOrder=:pqcWorkOrder GROUP by t.status")
	List<Object[]> getStatusByWoId(@Param("pqcWorkOrder") Long pqcWorkOrder);

	@Transactional
	@Modifying
	@Query("update PqcWorkOrderStepStatus t set t.status=:status where 1=1 "
			+ " AND  t.pqcWorkOrder=:pqcWorkOrder and t.step in :lstStep")
	void updateStep(@Param("pqcWorkOrder") Long pqcWorkOrder, @Param("status") String status, @Param("lstStep") List<String> lstStep);
}