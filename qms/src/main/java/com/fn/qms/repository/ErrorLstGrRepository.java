package com.fn.qms.repository;

import com.fn.qms.models.Error;
import com.fn.qms.models.ErrorLstGr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorLstGrRepository extends JpaRepository<ErrorLstGr, Long> {

}