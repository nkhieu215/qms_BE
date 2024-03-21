package com.fn.rd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.rd.models.ErrorList;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ErrorListRepository extends JpaRepository<ErrorList, Long> {

	@Query("SELECT t FROM ErrorList t where (:name is NULL OR t.name like %:name%) and t.parentId is null order by t.createdAt desc")
	Page<ErrorList>  searchByName(@Param("name")String name,Pageable pageable);
	
	@Query("SELECT t FROM ErrorList t where t.parentId is null order by t.createdAt desc")
	List<ErrorList>  getAllErrorCate();

	@Transactional
	@Modifying
	@Query(value = "delete from error_list  where parent_id  =:id",nativeQuery = true)
	void deleteFromParentId(@Param("id")Long id);

}