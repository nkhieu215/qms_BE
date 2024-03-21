package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;

@Repository
public interface PqcProfileRepository extends JpaRepository<PqcProfile, Long> {
	
}