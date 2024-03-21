package com.fn.qms.repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcDttdAssemblesError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PqcAssemblesErrorRepository extends JpaRepository<PqcDttdAssemblesError, Long> {

    @Modifying
    @Query(value = "delete from pqc_assembles_error where id=:id", nativeQuery = true)
    void deleteAssError(@Param("id") Long id);
}