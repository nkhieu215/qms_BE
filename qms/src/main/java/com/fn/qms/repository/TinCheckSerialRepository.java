package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcElectronicComponent;
import com.fn.qms.models.IqcExaminationType;
import com.fn.qms.models.PqcDttdTinCheckSerial;
import com.fn.rd.models.Employee;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TinCheckSerialRepository extends JpaRepository<PqcDttdTinCheckSerial, Long> {

	@Query("SELECT t FROM PqcDttdTinCheckSerial t where t.workOrderId = :workOrderId ")
	List<PqcDttdTinCheckSerial> lstTinCheckByWorkOrder(@Param("workOrderId") Long workorderId);

	@Transactional
	@Modifying
	@Query("delete from PqcDttdTinCheckSerial b where b.id=:id")
	void deleteTinCheckSerial(@Param("id") Long id);
}