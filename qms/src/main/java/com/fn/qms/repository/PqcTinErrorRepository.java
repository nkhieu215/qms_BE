package com.fn.qms.repository;

import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcDttdTinError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PqcTinErrorRepository extends JpaRepository<PqcDttdTinError, Long> {

	@Modifying
	@Override
	@Query(value = "delete from pqc_dttd_tin_error where id=:id", nativeQuery = true)
	void deleteById(@Param("id") Long id);
}