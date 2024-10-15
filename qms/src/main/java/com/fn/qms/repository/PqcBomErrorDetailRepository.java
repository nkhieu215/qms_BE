package com.fn.qms.repository;

import com.fn.qms.models.PqcBomErrorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcBomErrorDetailRepository extends JpaRepository<PqcBomErrorDetail,Integer> {
    public List<PqcBomErrorDetail> findAllByPqcWorkOrderId(Integer id);
    public List<PqcBomErrorDetail> findAllByPqcBomWorkOrderId(Integer id);
    public List<PqcBomErrorDetail> findAllByPqcBomQuantityId(Integer id);
}
