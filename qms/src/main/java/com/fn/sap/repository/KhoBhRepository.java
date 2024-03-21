package com.fn.sap.repository;

import com.fn.sap.models.KhoBh;
import com.fn.sap.models.SapBpGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoBhRepository extends JpaRepository<KhoBh, String> {

    @Query(value = "select t.* FROM \\[\\@KHO_BH\\] t order by t.Name asc", nativeQuery = true)
    List<KhoBh> getAll();
}