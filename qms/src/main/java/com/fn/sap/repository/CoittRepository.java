package com.fn.sap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.sap.models.Coitt;

@Repository
public interface CoittRepository extends JpaRepository<Coitt, String> {
	@Query(value = "select t.* FROM \\[\\@COITT\\] t where t.U_Versions=:version and t.U_ProNo=:productCode order by t.CreateDate desc", nativeQuery = true)
	List<Coitt> getBomVersionByProductCode(@Param("productCode") String productCode, @Param("version") String version);
}