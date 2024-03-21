package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStorePow;
import com.fn.qms.models.PqcStoreStructure;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreStructRepository extends JpaRepository<PqcStoreStructure, Long> {

	@Query("from PqcStoreStructure t where t.storeCheckId= :storeCheckId")
	List<PqcStoreStructure> getListCheckStructByStoreId( @Param("storeCheckId") Long storeCheckId);

	@Query("from PqcStoreStructure t where t.workOrderId= :workOrderId")
	List<PqcStoreStructure> getListCheckStructByWorkOrderId( @Param("workOrderId") Long workOrderId);

	@Transactional
	@Query("DELETE from PqcStoreStructure t where t.storeCheckId =:storeCheckId")
    void deleteAllByStoreCheckId(@Param("storeCheckId") Long storeCheckId);
}