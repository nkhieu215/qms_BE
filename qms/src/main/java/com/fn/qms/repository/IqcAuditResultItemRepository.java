package com.fn.qms.repository;

import com.fn.qms.models.IqcAuditResultItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IqcAuditResultItemRepository extends JpaRepository<IqcAuditResultItem,Integer> {
    public List<IqcAuditResultItem> findAllByIqcElecCompId(Integer id);
}
