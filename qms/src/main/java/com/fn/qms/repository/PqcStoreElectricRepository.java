package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStorePow;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreElectricRepository extends JpaRepository<PqcStorePow, Long> {

	@Query("from PqcStorePow t where t.storeCheckId= :storeCheckId")
	List<PqcStorePow> getListCheckElectricByStoreId(@Param("storeCheckId") Long storeCheckId);

	@Query("from PqcStorePow t where t.workOrderId= :workOrderId")
	List<PqcStorePow> getListCheckElectricByWoId(@Param("workOrderId") Long workOrderId);

	@Transactional
	@Query("DELETE from PqcStorePow t where t.storeCheckId =:storeCheckId")
	void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
	@Query(value = "select max(quantity_check) from `pqc_store_pow` where store_check_id = ?1",nativeQuery = true)
	Integer findMaxByPqcStoreCheck( Long storeCheckId);
}