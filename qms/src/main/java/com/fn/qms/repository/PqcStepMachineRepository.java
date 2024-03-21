package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcStepMachine;

@Repository
public interface PqcStepMachineRepository extends JpaRepository<PqcStepMachine, Long> {

	@Query("SELECT t FROM PqcStepMachine t where" + " t.stepCode = :stepCode ")
	List<PqcStepMachine> findListByCode(@Param("stepCode") String stepCode);

}
