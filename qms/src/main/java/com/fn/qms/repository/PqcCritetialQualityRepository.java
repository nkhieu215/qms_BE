package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaParameter;
import com.fn.qms.models.PqcCriteriaQuality;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PqcCritetialQualityRepository extends JpaRepository<PqcCriteriaQuality, Long> {

    @Modifying
    @Transactional
    @Query("DELETE from PqcCriteriaQuality t where t.id=?1")
    void deleteById(Long id);
}