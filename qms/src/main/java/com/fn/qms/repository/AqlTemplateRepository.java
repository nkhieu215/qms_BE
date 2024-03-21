package com.fn.qms.repository;

import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.PqcDttdTinCheckSerial;
import com.fn.qms.models.PqcWorkOrderView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface AqlTemplateRepository extends JpaRepository<AqlTemplate, Long> {


    @Query("SELECT t FROM AqlTemplate t where 1=1 "
            + " AND (:testLevel is NULL OR t.testLevel like %:testLevel%) "
            + " AND (:acceptanceLevel is NULL OR t.acceptanceLevel like %:acceptanceLevel%) "
            + " AND (:allowedError is NULL OR t.allowedError like %:allowedError%) "
            + " order by t.createdAt desc")
    Page<AqlTemplate> findList(@Param("testLevel") String testLevel, @Param("acceptanceLevel") String acceptanceLevel,
                                          @Param("allowedError") String allowedError, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from AqlTemplate b where b.id=:id")
    void deleteTemplate(@Param("id") Long id);
}