package com.fn.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.sap.models.Citt1;

import java.util.List;

@Repository
public interface Citt1Repository extends JpaRepository<Citt1, String> {

    @Query(value = "select t.* FROM \\[\\@CITT1\\] t where t.DocEntry=:docEntry and t.U_ItemCode is not null", nativeQuery = true)
    List<Citt1> getListByDocEntry(@Param("docEntry") Integer docEntry);
}