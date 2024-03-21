package com.fn.qms.repository;

import com.fn.qms.models.IqcExaminationType;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.models.SettingLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface SettingLineRepository extends JpaRepository<SettingLine, Long> {

    Integer deleteSettingLineBySource(String source);

    @Query("SELECT t FROM SettingLine t where 1=1 "
            + " AND (:name is NULL OR t.name like %:name%) "
            + " AND (:code is NULL OR t.code like %:code%) "
            + " order by t.createdAt desc")
    Page<SettingLine> getListByPage(@Param("name")String name,@Param("code") String code,Pageable pageable);
}