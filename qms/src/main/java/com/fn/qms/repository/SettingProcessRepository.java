package com.fn.qms.repository;

import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.SettingProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SettingProcessRepository extends JpaRepository<SettingProcess, Long> {

    @Query("SELECT t FROM SettingProcess t where 1=1 "
            + " AND (:name is NULL OR t.name like %:name%) "
            + " AND (:code is NULL OR t.code like %:code%) "
            + " order by t.createdAt desc")
    Page<SettingProcess> findList(@Param("name") String name, @Param("code") String code, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from AqlTemplate b where b.id=:id")
    void deleteTemplate(@Param("id") Long id);
}