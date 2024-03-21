package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditResultNvl;
import com.fn.qms.models.IqcAuditResultParameter;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IqcAuditResultParamRepository extends JpaRepository<IqcAuditResultParameter, Long> {

    @Transactional
    @Modifying
    @Query("delete from IqcAuditResultParameter t where t.id=?1")
    void deleteById(Long id);
}