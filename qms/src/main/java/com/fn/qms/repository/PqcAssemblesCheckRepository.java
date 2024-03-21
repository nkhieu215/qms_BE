package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdSolderCheck;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcProfile;
import com.fn.qms.models.PqcWorkOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PqcAssemblesCheckRepository extends JpaRepository<PqcAssemblesSuccessCheck, Long> {

    @Modifying
    @Transactional
    @Query("DELETE from PqcAssemblesSuccessCheck t where t.id=?1")
    void deleteById(Long id);

    @Query("FROM PqcAssemblesSuccessCheck b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
    List<PqcAssemblesSuccessCheck> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);
}