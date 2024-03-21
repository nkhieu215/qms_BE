package com.fn.sap.repository;

import com.fn.sap.models.Color;
import com.fn.sap.models.OWHS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color, String> {

    @Query(value = "select t.* FROM \\[\\@SAP_COLOR\\] t order by t.Name asc", nativeQuery = true)
    List<Color> findAll();
}