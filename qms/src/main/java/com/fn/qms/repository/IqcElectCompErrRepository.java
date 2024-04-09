package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditResultNvl;
import com.fn.qms.models.IqcElectCompErr;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IqcElectCompErrRepository extends JpaRepository<IqcElectCompErr, Long> {

    @Transactional
    @Modifying
    @Query("DELETE from IqcElectCompErr t where t.id=?1")
    void deleteById(Long id);
    @Query(value="select " +
            "a.quantity," +
            "a.err_name," +
            "b.checking_quantity," +
            "b.elec_comp_code," +
            "b.elect_comp_name " +
            "from `iqc_elect_comp_err` as a " +
            "inner join iqc_electronic_component as b on a.elect_comp_id = b.id " +
            "where b.created_at >=?1 " +
            "and b.created_at <=?2 " +
            "and b.elec_comp_code like %?3% " +
            "and b.elect_comp_name like %?4% ;",nativeQuery = true)
    public List<Object[]> getIqcElectCompErrList(String startDate,String endDate,String productCode,String productName);
}