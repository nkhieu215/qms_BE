package com.fn.qms.repository;

import com.fn.qms.models.Menu;
import com.fn.qms.models.StepProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepProcessRepository extends JpaRepository<StepProcess, Long> {

    @Query("SELECT t FROM StepProcess t where t.idStage =:id")
    StepProcess findByIdStage(@Param("id") String id);
}