package com.fn.qms.repository;

import com.fn.qms.models.IqcExaminationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IqcExaminationItemRepository extends JpaRepository<IqcExaminationItem,Integer> {
    public List<IqcExaminationItem> findAllByIqcExamId(Integer id);
}
