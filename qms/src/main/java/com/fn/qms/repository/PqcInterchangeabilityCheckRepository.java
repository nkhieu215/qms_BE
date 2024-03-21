package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PqcInterchangeabilityCheckRepository extends JpaRepository<PqcDttdInterchangeabilityCheck, Long> {
    @Modifying
    @Query("DELETE PqcDttdInterchangeabilityCheck c WHERE c.id = ?1")
    void removeById(Long id);

}