package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStorePacking;
import com.fn.qms.models.PqcStorePow;

@Repository
public interface PqcStorePackingRepository extends JpaRepository<PqcStorePacking, Long> {

	@Query("from PqcStorePacking t where t.storeCheckId= :storeCheckId")
	List<PqcStorePacking> getListCheckPackingByStoreId(@Param("storeCheckId") Long storeCheckId);

	@Query("from PqcStorePacking t where t.workOrderId= :woId")
	List<PqcStorePacking> getListCheckPackingByWoId(@Param("woId") Long woId);
}