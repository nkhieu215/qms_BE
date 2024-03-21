package com.fn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.TransactionHistory;

@Repository
public interface TransactionHisRepository extends JpaRepository<TransactionHistory, Long> {

}