package com.fn.qms.repository;

import com.fn.qms.models.QrFeederHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QrFeederHistoryRepository extends JpaRepository<QrFeederHistory,Integer> {
    public List<QrFeederHistory> findAllByMachineCodeOrderByTimeUpdateDesc(String machineCode);
    @Query(value = "" +
            "select * from `qr_feeder_history` " +
            "where machine_code like ?1 and main_qr_feeder like ?2 order by time_update desc ;",nativeQuery = true)
    public List<QrFeederHistory> searchByMachineCodeAndMainQrFeederOrderByTimeUpdateDesc(String machineCode, String mainQrFeeder);
}
