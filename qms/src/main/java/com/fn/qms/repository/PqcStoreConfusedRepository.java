package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStoreConfused;
import com.fn.qms.models.PqcStorePow;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreConfusedRepository extends JpaRepository<PqcStoreConfused, Long> {

	@Query("from PqcStoreConfused t where t.storeCheckId= :storeCheckId")
	List<PqcStoreConfused> getListCheckConfusedByStoreId(@Param("storeCheckId") Long storeCheckId);


	@Query("from PqcStoreConfused t where t.workOrderId= :woId")
	List<PqcStoreConfused> getListByWoId(@Param("woId") Long woId);

	@Transactional
	@Query("DELETE from PqcStoreConfused t where t.storeCheckId =:storeCheckId")
	void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
}