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
}