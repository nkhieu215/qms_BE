package com.fn.qms.repository;

import com.fn.qms.models.Error;
import com.fn.qms.models.IqcElectCompErr;
import com.fn.qms.models.IqcElectCompErrResponse;
import com.fn.qms.models.IqcExaminationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {

    @Query("SELECT t FROM Error t where t.idError =:id")
    Error findByIdStage(@Param("id") String id);

    @Query("SELECT t FROM Error t where 1=1"
            + " AND (:name is NULL OR t.name like %:name% OR  t.label like %:name%)"
            )
    List<Error> searchListByName(@Param("name") String name);
    @Query(value="" +
            "select " +
            "a.id as id," +
            "a.name as errCode," +
            "a.label as errName " +
            "from `error` as a ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> getAll();
}