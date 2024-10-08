package com.fn.qms.repository;

import com.fn.qms.models.Error;
import com.fn.qms.models.ErrorLstGr;
import com.fn.qms.models.IqcElectCompErrResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorLstGrRepository extends JpaRepository<ErrorLstGr, Long> {
    @Query(value = "SELECT \n" +
            "b.name as errCode,\n" +
            "b.label as errName\n" +
            "FROM `error_lst_gr` as a \n" +
            "inner join qms2.error as b on b.id = a.id_error \n" +
            "where a.id_err_gr = ?1 ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> getByErrorId(Integer id);
    @Query(value="" +
            "SELECT " +
            "            b.name as errCode, \n" +
            "            b.label as errName \n" +
            "            FROM `error_lst_gr` as a  \n" +
            "            right join qms2.error as b on b.id = a.id_error  \n" +
            "            where a.id_err_gr is null ;",nativeQuery = true)
    public List<IqcElectCompErrResponse> getByErrorNull();
}