package com.fn.qms.repository;

import com.fn.qms.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PqcMountCompCheckRepository extends JpaRepository<PqcDttdMountCompCheck, Long> {

    @Query("FROM PqcDttdMountCompCheck b WHERE UPPER(b.conclude) IN :conclude AND b.workOrderId =:woId AND UPPER(b.checkPerson) =UPPER(:checkPerson)  ")
    List<PqcDttdMountCompCheck> getLstCheckNoti(@Param("conclude") List<String> conclude, @Param("woId") Long woId, @Param("checkPerson") String checkPerson);

    @Modifying
    @Override
    @Query(value = "DELETE FROM pqc_dttd_mount_comp_check WHERE dttd_mount_comp_id =:id", nativeQuery = true)
    void deleteById(@Param("id") Long id);
}