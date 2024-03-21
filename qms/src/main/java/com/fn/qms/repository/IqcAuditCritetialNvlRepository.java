package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaNvl;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IqcAuditCritetialNvlRepository extends JpaRepository<IqcAuditCriteriaNvl, Long> {

	@Query("SELECT t FROM IqcAuditCriteriaNvl t where t.templateId =:templateId")
	List<IqcAuditCriteriaNvl> findExaminationListByName(@Param("templateId") Long templateId);

	@Transactional
	@Modifying
	@Query(value = "DELETE  FROM iqc_audit_criteria_nvl WHERE id =:id", nativeQuery = true)
	void deleteByIdNvl(@Param("id") Long templateId);
}