package com.fn.sap.repository;

import com.fn.sap.models.OWHS;
import com.fn.sap.models.SapBpGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwhsRepository extends JpaRepository<OWHS, String> {

    @Query(value = "select t.* FROM OWHS t order by t.WhsName asc", nativeQuery = true)
    List<OWHS> findAll();
}