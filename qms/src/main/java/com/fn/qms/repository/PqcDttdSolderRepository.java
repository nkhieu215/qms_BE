package com.fn.qms.repository;

import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcErrorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcDttdSolderRepository extends JpaRepository<PqcDttdSolderCheck, Long> {

	@Modifying
	@Query("delete from PqcDttdSolderCheck t where t.id = ?1")
	void deleteById(Long id);
}