package com.fn.sap.repository;

import com.fn.sap.models.Coitt;
import com.fn.sap.models.Ocrd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcrdRepository extends JpaRepository<Ocrd, String> {
	@Query(value = "select t.* FROM \\[\\OCRD\\] t where t.CardName like %:name% order by t.CardName asc", nativeQuery = true)
	List<Ocrd> findByName(@Param("name") String name);
}