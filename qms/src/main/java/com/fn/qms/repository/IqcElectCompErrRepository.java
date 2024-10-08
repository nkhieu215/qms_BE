package com.fn.qms.repository;

import java.util.List;

import com.fn.qms.models.IqcElectCompErrResponse;
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
    @Query(value = "" +
            "SELECT \n" +
            "b.item_code as itemCode,\n" +
            "a.err_group as errGroup,\n" +
            "a.err_code as errCode,\n" +
            "a.err_name as errName,\n" +
            "sum(a.quantity) as quantity\n" +
            " FROM `iqc_elect_comp_err` as a\n" +
            " inner join qms2.iqc_audit_result_item as b on b.id = a.audit_result_item_id \n" +
            " where elect_comp_id = ?1 \n" +
            "group by a.audit_result_item_id,a.err_group,a.err_code,a.err_name\n" +
            "order by b.item_code ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> getListErrByElectCompId(Long id);
    @Query(value = "SELECT \n" +
            "a.id as id,\n" +
            "a.err_group as errGroup,\n" +
            "a.err_code as errCode,\n" +
            "a.err_name as errName,\n" +
            "a.quantity as quantity,\n" +
            "a.created_at as createdAt,\n" +
            "a.note as note,\n" +
            "a.ratio as ratio,\n" +
            "b.item_code as itemCode\n" +
            "FROM `iqc_elect_comp_err` as a\n" +
            "inner join qms2.iqc_audit_result_item as b on b.id = a.audit_result_item_id\n" +
            "where a.audit_result_item_id = ?1 " +
            "order by a.id desc ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> getListErrByAuditResultItemId(Integer id);
    @Query(value = "SELECT \n" +
            "a.id as id,\n" +
            "a.err_group as errGroup,\n" +
            "a.err_code as errCode,\n" +
            "a.err_name as errName,\n" +
            "a.quantity as quantity,\n" +
            "a.created_at as createdAt,\n" +
            "a.note as note,\n" +
            "a.ratio as ratio,\n" +
            "b.item_code as itemCode\n" +
            "FROM `iqc_elect_comp_err` as a\n" +
            "inner join qms2.iqc_audit_result_item as b on b.id = a.audit_result_item_id\n" +
            "where a.err_group like ?1 " +
            "and a.err_code like ?2 " +
            "and a.err_name like ?3 " +
            "and b.item_code like ?4 " +
            "and a.elect_comp_id = ?5 " +
            "order by b.item_code  ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> findInListErrors(String errGroup,
                                                          String errCode,
                                                          String errName,
                                                          String itemCode,
                                                          Integer electCompId);
    public List<IqcElectCompErr> findAllByElectCompId(Long id);
}