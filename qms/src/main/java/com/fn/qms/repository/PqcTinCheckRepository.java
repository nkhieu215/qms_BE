package com.fn.qms.repository;

import com.fn.qms.models.PqcStoreCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fn.qms.models.PqcDttdTinCheck;

import java.util.List;

@Repository
public interface PqcTinCheckRepository extends JpaRepository<PqcDttdTinCheck, Long> {

	@Transactional
	@Modifying
	@Query("delete from PqcDttdTinCheck b where b.dttdCheckId=:dttdCheckId")
	void deleteTinCheck(@Param("dttdCheckId") Long id);

	@Query("FROM PqcDttdTinCheck b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
	List<PqcDttdTinCheck> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);
}