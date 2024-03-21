package com.fn.qms.repository;

import com.fn.qms.models.SettingLine;
import com.fn.qms.models.SettingMachine;
import com.fn.qms.models.StepProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SettingMachineRepository extends JpaRepository<SettingMachine, Long> {

    Integer deleteSettingLineBySource(String source);

    @Query("SELECT t FROM SettingMachine t where 1=1 "
            + " AND (:name is NULL OR t.name like %:name%) "
            + " AND (:code is NULL OR t.code like %:code%) "
            + " order by t.createdAt desc")
    Page<SettingMachine> getListByPage(@Param("name")String name,@Param("code") String code,Pageable pageable);

    @Query("SELECT t FROM SettingMachine t where t.idScada =:id")
    SettingMachine findByIdStage(@Param("id") String id);
}