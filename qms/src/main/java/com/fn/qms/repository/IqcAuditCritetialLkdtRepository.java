package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaLkdt;
import com.fn.qms.models.IqcAuditCriteriaNvl;

@Repository
public interface IqcAuditCritetialLkdtRepository extends JpaRepository<IqcAuditCriteriaLkdt, Long> {
	
}