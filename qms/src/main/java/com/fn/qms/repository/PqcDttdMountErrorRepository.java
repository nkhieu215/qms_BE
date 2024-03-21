package com.fn.qms.repository;

import com.fn.qms.models.PqcDttdMountError;
import com.fn.qms.models.PqcDttdSolderError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PqcDttdMountErrorRepository extends JpaRepository<PqcDttdMountError, Long> {


    @Modifying
    @Override
    @Query(value = "delete from pqc_dttd_mount_error where id=:id", nativeQuery = true)
    void deleteById(@Param("id") Long id);
}