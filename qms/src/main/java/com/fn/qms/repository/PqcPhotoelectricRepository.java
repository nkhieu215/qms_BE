package com.fn.qms.repository;

import com.fn.qms.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.PathParam;
import java.util.List;

@Transactional
@Repository
public interface PqcPhotoelectricRepository extends JpaRepository<PqcPhotoelectric, Long> {
    @Modifying
    @Query("delete from PqcPhotoelectric t where t.id = ?1")
    void deleteById(@Param("id") Long id);

    @Query("FROM PqcPhotoelectric b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.createdBy) =UPPER(:checkPerson)  ")
    List<PqcPhotoelectric> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);
}