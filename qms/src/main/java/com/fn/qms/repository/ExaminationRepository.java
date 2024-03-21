package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcExaminationType;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExaminationRepository extends JpaRepository<IqcExaminationType, Long> {
	
	@Query("SELECT t FROM IqcExaminationType t where (:name is NULL OR t.name like %:name%) and (:code is NULL OR t.code like %:code%)  and t.type=:type order by t.createdAt desc")
	Page<IqcExaminationType> findExaminationListByName(@Param("type") int typeExaminationId ,@Param("name") String name,@Param("code") String code ,Pageable pageable);

	@Query("SELECT t FROM IqcExaminationType t where t.code =:code and t.type =:type")
	IqcExaminationType findByCode(@Param("code")  String code,@Param("type")  int typeExaminationId);
	
	@Query("SELECT t FROM IqcExaminationType t where (:code is NULL OR t.code like %:code%)  and t.type=:type AND t.status=1 order by t.createdAt desc")
	List<IqcExaminationType> searchListByCode(@Param("type") int type ,@Param("code") String code);

	@Modifying
	@Transactional
	@Query("DELETE FROM IqcExaminationType t where t.id=?1")
	void deleteExById(Long id);

}