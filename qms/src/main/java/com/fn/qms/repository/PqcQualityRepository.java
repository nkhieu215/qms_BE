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
    @Query(value="select " +
            "c.conclude, " +
            "b.production_code, " +
            "b.production_name, " +
            "b.branch_name, " +
            "b.group_name " +
            "from `pqc_quality` as c " +
            "inner join pqc_work_order as b " +
            "on c.work_order_id = b.id " +
            "where b.created_at >=?1 " +
            "and b.created_at <=?2 " +
            "and b.production_code like %?3% " +
            "and b.production_name like %?4% " +
            "and b.branch_name like %?5% " +
            "and b.group_name like %?6% ;",nativeQuery = true)
    public List<Object[]> getPqcQualityConclude(String startDate, String endDate,String productCode,String productName,String branchName,String groupName);
}