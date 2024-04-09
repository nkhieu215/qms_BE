package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcPhotoelectric;
import com.fn.qms.models.PqcPhotoelectricParam;
import com.fn.qms.models.PqcPhotoelectricProduct;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;

import java.util.List;

@Repository
public interface PqcPhotoelectricProductRepository extends JpaRepository<PqcPhotoelectricProduct, Long> {
    @Modifying
    @Query("delete from PqcPhotoelectricProduct t where t.id = ?1")
    void deleteById(@Param("id") Long id);

    @Query("FROM PqcPhotoelectricProduct b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
    List<PqcPhotoelectricProduct> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);
    @Query(value="select " +
            "a.quatity, " +
            "a.conclude, " +
            "b.production_code, " +
            "b.production_name, " +
            "b.branch_name, " +
            "b.group_name " +
            "from `pqc_photoelectric_product` a inner join " +
            "pqc_work_order as b on a.work_order_id = b.id " +
            "where b.created_at >=?1 " +
            "and b.created_at <=?2 " +
            "and b.production_code like %?3% " +
            "and b.production_name like %?4% " +
            "and b.branch_name like %?5% " +
            "and b.group_name like %?6% ;",nativeQuery = true)
    public List<Object[]> getPqcPhotoElectList(String startDate, String endDate,String productCode,String productName,String branchName,String groupName);
}