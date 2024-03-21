package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditResultNvl;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IqcAuditResultNvlRepository extends JpaRepository<IqcAuditResultNvl, Long> {
    @Modifying
    @Transactional
    @Query("delete from IqcAuditResultNvl t where t.id=?1")
    void deleteById(Long id);
}