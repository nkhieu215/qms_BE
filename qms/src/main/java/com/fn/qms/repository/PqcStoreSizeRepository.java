package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStorePow;
import com.fn.qms.models.PqcStoreSize;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreSizeRepository extends JpaRepository<PqcStoreSize, Long> {

	@Query("from PqcStoreSize t where t.storeCheckId= :storeCheckId")
	List<PqcStoreSize> getListCheckSizeByStoreId(@Param("storeCheckId") Long storeCheckId);


	@Query("from PqcStoreSize t where t.workOrderId= :workOrderId")
	List<PqcStoreSize> getListCheckSizeByWorkOrderId(@Param("workOrderId") Long workOrderId);

	@Transactional
	@Query("DELETE from PqcStoreSize t where t.storeCheckId =:storeCheckId")
	void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
	@Query(value = "select max(quatity) from `pqc_store_size` where store_check_id = ?1",nativeQuery = true)
	Integer findMaxByPqcStoreCheck( Long storeCheckId);
}