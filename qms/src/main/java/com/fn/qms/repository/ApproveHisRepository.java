package com.fn.qms.repository;

import com.fn.qms.models.ApproveHis;
import com.fn.qms.models.IqcElectronicComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApproveHisRepository extends JpaRepository<ApproveHis, Long> {

}