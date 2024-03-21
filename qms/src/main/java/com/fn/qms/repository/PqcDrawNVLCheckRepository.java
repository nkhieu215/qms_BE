package com.fn.qms.repository;

import java.util.List;

import com.fn.qms.models.PqcBomWorkorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fn.qms.models.PqcDrawTestNvl;

@Repository
public interface PqcDrawNVLCheckRepository extends JpaRepository<PqcDrawTestNvl, Long> {

	@Transactional
	@Modifying
	@Query("delete from PqcDrawTestNvl b where b.pqcDrawNvlId=:pqcDrawNvlId")
	void deleteFromDrawId(@Param("pqcDrawNvlId") Long id);
	
	
	@Query("from PqcDrawTestNvl b where b.pqcDrawNvlId=:pqcDrawNvlId")
	List<PqcDrawTestNvl> getLstCheckByOrderId(@Param("pqcDrawNvlId") Long pqcDrawNvlId);

	@Query("from PqcDrawTestNvl t where t.workOrderId= :woId")
	List<PqcDrawTestNvl> getListByWoId(@Param("woId") Long woId);
}