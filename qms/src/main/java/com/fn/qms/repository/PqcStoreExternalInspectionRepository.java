package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStoreExternalInspection;
import com.fn.qms.models.PqcStorePow;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreExternalInspectionRepository extends JpaRepository<PqcStoreExternalInspection, Long> {

	@Query("from PqcStoreExternalInspection t where t.storeCheckId= :storeCheckId")
	List<PqcStoreExternalInspection> getListExternalInspectionByStoreId(@Param("storeCheckId") Long storeCheckId);

	@Query("from PqcStoreExternalInspection t where t.workOrderId= :workOrderId")
	List<PqcStoreExternalInspection> getListExternalInspectionByWorkOrderId(@Param("workOrderId") Long storeCheckId);

	@Transactional
	@Query("DELETE from PqcStoreExternalInspection t where t.storeCheckId =:storeCheckId")
	void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
	@Query(value = "select max(quantity) from `pqc_store_external_inspection` where store_check_id = ?1",nativeQuery = true)
	Integer findMaxByPqcStoreCheck( Long storeCheckId);
}