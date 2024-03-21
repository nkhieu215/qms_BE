package com.fn.qms.repository;

import com.fn.qms.models.ErrorGroup;
import com.fn.qms.models.StepProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorGroupRepository extends JpaRepository<ErrorGroup, Long> {

    @Query("SELECT t FROM ErrorGroup t where t.idGr =:id")
    ErrorGroup findByIdStage(@Param("id") String id);
}