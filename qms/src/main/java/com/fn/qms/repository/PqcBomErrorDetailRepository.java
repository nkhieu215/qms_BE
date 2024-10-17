package com.fn.qms.repository;

import com.fn.qms.models.PqcBomErrorDetail;
import com.fn.qms.models.PqcBomErrorDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcBomErrorDetailRepository extends JpaRepository<PqcBomErrorDetail,Integer> {
    @Query(value = "SELECT \n" +
            "b.item_name as itemName,\n" +
            "b.item_code as itemCode,\n" +
            "a.id as id,\n" +
            "a.error_code as errorCode,\n" +
            "a.error_name as errorName,\n" +
            "a.quantity as quantity,\n" +
            "d.quantity as quantity2,\n" +
            "a.created_at as createdAt,\n" +
            "a.updated_at as updatedAt,\n" +
            "a.note as note,\n" +
            "a.pqc_bom_quantity_id as pqcBomQuantityId,\n" +
            "a.pqc_work_order_id as pqcWorkOrderId,\n" +
            "a.pqc_bom_work_order_id as pqcBomWorkOrderId\n" +
            " FROM `pqc_bom_error_detail` as a \n" +
            " inner join qms2.pqc_bom_workorder as b on b.id = a.pqc_bom_work_order_id\n" +
            " inner join qms2.pqc_work_order as c on c.id = a.pqc_work_order_id\n" +
            " inner join qms2.pqc_bom_quantity as d on d.id = a.pqc_bom_quantity_id" +
            " where a.pqc_work_order_id = ?1 " +
            " order by a.updated_at desc ; ",nativeQuery = true)
    public List<PqcBomErrorDetailResponse> getAllByPqcWorkOrderId(Integer id);
    @Query(value = "SELECT \n" +
            "b.item_name as itemName,\n" +
            "b.item_code as itemCode,\n" +
            "a.id as id,\n" +
            "a.error_code as errorCode,\n" +
            "a.error_name as errorName,\n" +
            "a.quantity as quantity,\n" +
            "d.quantity as quantity2,\n" +
            "a.created_at as createdAt,\n" +
            "a.updated_at as updatedAt,\n" +
            "a.note as note,\n" +
            "a.pqc_bom_quantity_id as pqcBomQuantityId,\n" +
            "a.pqc_work_order_id as pqcWorkOrderId,\n" +
            "a.pqc_bom_work_order_id as pqcBomWorkOrderId\n" +
            " FROM `pqc_bom_error_detail` as a \n" +
            " inner join qms2.pqc_bom_workorder as b on b.id = a.pqc_bom_work_order_id\n" +
            " inner join qms2.pqc_work_order as c on c.id = a.pqc_work_order_id\n" +
            " inner join qms2.pqc_bom_quantity as d on d.id = a.pqc_bom_quantity_id" +
            " where a.pqc_bom_work_order_id = ?1 " +
            " order by a.updated_at desc ; ",nativeQuery = true)
    public List<PqcBomErrorDetailResponse> getAllByPqcBomWorkOrderId(Integer id);
    @Query(value = "SELECT \n" +
            "b.item_name as itemName,\n" +
            "b.item_code as itemCode,\n" +
            "a.id as id,\n" +
            "a.error_code as errorCode,\n" +
            "a.error_name as errorName,\n" +
            "a.quantity as quantity,\n" +
            "d.quantity as quantity2,\n" +
            "a.created_at as createdAt,\n" +
            "a.updated_at as updatedAt,\n" +
            "a.note as note,\n" +
            "a.pqc_bom_quantity_id as pqcBomQuantityId,\n" +
            "a.pqc_work_order_id as pqcWorkOrderId,\n" +
            "a.pqc_bom_work_order_id as pqcBomWorkOrderId\n" +
            " FROM `pqc_bom_error_detail` as a \n" +
            " inner join qms2.pqc_bom_workorder as b on b.id = a.pqc_bom_work_order_id\n" +
            " inner join qms2.pqc_work_order as c on c.id = a.pqc_work_order_id\n" +
            " inner join qms2.pqc_bom_quantity as d on d.id = a.pqc_bom_quantity_id" +
            " where a.pqc_bom_quantity_id = ?1 " +
            " order by a.updated_at desc ; ",nativeQuery = true)
    public List<PqcBomErrorDetailResponse> getAllByPqcBomQuantityId(Integer id);
    @Modifying
    @Query(value = "delete from `pqc_bom_error_detail` where pqc_bom_quantity_id = ?1 ;",nativeQuery = true)
    public void deletedByPqcBomQuantityId(Integer id);
}
