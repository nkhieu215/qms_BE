package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcDrawNvl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PqcDrawNvlRepository extends JpaRepository<PqcDrawNvl, Long> {
    PqcDrawNvl findAllById(Long id);

    @Query("DELETE FROM PqcDrawNvl b WHERE b.id=:id")
    @Modifying
    @Transactional
    void deleteByIdNVL(@Param("id") Long id);

    @Query("FROM PqcDrawNvl b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
    List<PqcDrawNvl> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);
}
