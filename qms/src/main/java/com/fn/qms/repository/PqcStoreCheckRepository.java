package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;

@Repository
public interface PqcStoreCheckRepository extends JpaRepository<PqcStoreCheck, Long> {

	@Query("from PqcStoreCheck t where t.workOrderId = :workOrderId and (t.status != 99 or t.status is null) ")
	List<PqcStoreCheck> getListCheckStoreByWo(@Param("workOrderId")Long workOrderId);

	@Query("FROM PqcStoreCheck b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
	List<PqcStoreCheck> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);

	@Query("from PqcStoreCheck t where t.statusApproveSap = 'WAIT_APPROVE'")
	List<PqcStoreCheck> getLstStoreWaitApprove();

	@Query(value = "SELECT SUM(pqc_store_check.`quatity_store`) AS total ,  SUM(pqc_store_check.`quantity_store_sap`) AS total_sap FROM `pqc_store_check` WHERE pqc_store_check.`work_order_id` =:workOrderId", nativeQuery = true)
	List<Object[]> getTotalStoreByWoId(@Param("workOrderId")Long workOrderId);

	@Query(value = "SELECT SUM(pqc_store_check.`quatity_store`) AS total ,  SUM(pqc_store_check.`quantity_store_sap`) AS total_sap FROM `pqc_store_check` WHERE pqc_store_check.`work_order_id` in :workOrderId", nativeQuery = true)
	List<Object[]> getTotalStoreByWoId(@Param("workOrderId")List<Long> workOrderId);
	@Query(value = "select a.id,a.work_order_id,b.quatity_store,b.conclude,a.product_type from `pqc_store_check` as b " +
			"inner join pqc_work_order as a on b.work_order_id = a.id",nativeQuery = true)
	public List<Object[]> getListPqcStoreCheck();
}