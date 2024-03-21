package com.fn.qms.repository;

import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.NotiConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NotiConfigRepository extends JpaRepository<NotiConfig, Long> {
}