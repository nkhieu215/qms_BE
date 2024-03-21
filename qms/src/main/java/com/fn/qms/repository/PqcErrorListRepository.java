package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;

@Repository
public interface PqcErrorListRepository extends JpaRepository<PqcErrorList, Long> {

	@Query("SELECT t FROM PqcErrorList t where 1=1 "
			+ " AND (:dttdCheckId is NULL OR t.dttdCheckId=:dttdCheckId ) "
			+ " AND (:dttdType is NULL OR t.dttdType=:dttdType) ")
	List<PqcErrorList> getLstErrorStepByIdcheck(@Param("dttdCheckId") Long dttdCheckId, @Param("dttdType") String dttdType);
	
}