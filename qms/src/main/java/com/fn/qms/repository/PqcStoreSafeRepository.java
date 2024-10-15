package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStorePow;
import com.fn.qms.models.PqcStoreSafe;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreSafeRepository extends JpaRepository<PqcStoreSafe, Long> {

	@Query("from PqcStoreSafe t where t.storeCheckId= :storeCheckId")
	List<PqcStoreSafe> getListCheckSafeByStoreId(@Param("storeCheckId") Long storeCheckId);


	@Query("from PqcStoreSafe t where t.workOrderId= :workOrderId")
	List<PqcStoreSafe> getListCheckSafeByWorkOrderId(@Param("workOrderId") Long workOrderId);

	@Transactional
	@Query("DELETE from PqcStoreSafe t where t.storeCheckId =:storeCheckId")
	void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
	@Query(value = "select max(quatity) from `pqc_store_safe` where store_check_id = ?1",nativeQuery = true)
	Integer findMaxByPqcStoreCheck( Long storeCheckId);
}