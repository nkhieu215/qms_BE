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
    @Query(value="select " +
            "a.quantity, " +
            "a.conclude, " +
            "b.production_code, " +
            "b.production_name, " +
            "b.branch_name, " +
            "b.group_name " +
            "from `pqc_photoelectric` a inner join " +
            "pqc_work_order as b on a.work_order_id = b.id " +
            "where b.created_at >=?1 " +
            "and b.created_at <=?2 " +
            "and b.production_code like %?3% " +
            "and b.production_name like %?4% " +
            "and b.branch_name like %?5% " +
            "and b.group_name like %?6% ;",nativeQuery = true)
    public List<Object[]> getPqcPhotoElectList(String startDate, String endDate,String productCode, String productName,String branchName,String groupName);

}