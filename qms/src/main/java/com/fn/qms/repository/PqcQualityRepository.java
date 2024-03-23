package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcQuality;

import java.util.List;

@Repository
public interface PqcQualityRepository extends JpaRepository<PqcQuality, Long> {
    @Modifying
    @Query("delete from PqcQuality t where t.id = ?1")
    void deleteById(@Param("id") Long id);
    @Query(value="select c.conclude from `pqc_quality` as c inner join pqc_work_order as b " +
            "on c.work_order_id = b.id",nativeQuery = true)
    public List<Object> getPqcQualityConclude();
}