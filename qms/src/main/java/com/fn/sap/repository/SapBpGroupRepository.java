package com.fn.sap.repository;

import com.fn.sap.models.Oitm;
import com.fn.sap.models.SapBpGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SapBpGroupRepository extends JpaRepository<SapBpGroup, String> {

    @Query(value = "select t.* FROM \\[\\@SAP_BPGROUP\\] t order by t.Name asc", nativeQuery = true)
    List<SapBpGroup> findAll();
}