package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.models.PqcStoreErr;
import com.fn.qms.models.PqcStorePow;

import javax.transaction.Transactional;

@Repository
public interface PqcStoreErrorRepository extends JpaRepository<PqcStoreErr, Long> {

	@Query("from PqcStoreErr t where t.storeCheckId= :storeCheckId")
	List<PqcStoreErr> getListCheckErryByStoreId(@Param("storeCheckId") Long storeCheckId);

	@Query("from PqcStoreErr t where t.storeCheckId in :storeCheckId")
	List<PqcStoreErr> getByListStoreCheck(@Param("storeCheckId") List<Long> storeCheckId);

	@Transactional
	@Query(value = "DELETE from pqc_store_err t where t.store_check_id =:storeCheckId", nativeQuery = true)
	void deleteAllByStoreCheckId(@Param("storeCheckId")Long id);

	//	@Override
	//	@Modifying
	//	@Query("DELETE FROM PqcStoreErr t where t.id = ?1")
	//	void deleteById(Long id);
}