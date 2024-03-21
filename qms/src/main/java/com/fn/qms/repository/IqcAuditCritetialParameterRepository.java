package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaParameter;

@Repository
public interface IqcAuditCritetialParameterRepository extends JpaRepository<IqcAuditCriteriaParameter, Long> {
	
}