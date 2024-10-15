package com.fn.qms.repository;

import com.fn.qms.models.PqcBomQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqcBomQuantityRepository extends JpaRepository<PqcBomQuantity,Integer> {
    public List<PqcBomQuantity> findAllByPqcBomWorkOrderId(Integer id);
}
