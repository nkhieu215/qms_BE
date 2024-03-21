package com.fn.qms.repository;

import com.fn.qms.models.PqcDttdSolderError;
import com.fn.qms.models.PqcErrorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcDttdSolderErrorRepository extends JpaRepository<PqcDttdSolderError, Long> {


    @Modifying
    @Override
    @Query(value = "delete from pqc_dttd_solder_error where id=:id", nativeQuery = true)
    void deleteById(@Param("id") Long id);
}