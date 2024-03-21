package com.fn.sap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.sap.models.Oitm;

@Repository
public interface OitmRepository extends JpaRepository<Oitm, String> {

	@Query(value = "SELECT t.itemName, t.itemCode FROM Oitm t where (:itemCode is NULL OR t.itemCode like %:itemCode%) order by createDate desc", nativeQuery = false)
	List<Object[]> searchOitmByCode(@Param("itemCode") String code);

		
}