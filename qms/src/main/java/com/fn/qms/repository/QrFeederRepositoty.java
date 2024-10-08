package com.fn.qms.repository;

import com.fn.qms.models.QrFeeder;
import com.fn.qms.models.QrFeederResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QrFeederRepositoty extends JpaRepository<QrFeeder,Integer> {
    @Query(value="" +
            "select qr_feeder_code as qrFeederCode," +
            "'Active' as status," +
            " '' as checkType " +
            " from `qr_feeder` where feeder_group_id = ?1 and status = 1 ;",nativeQuery = true)
    public List<QrFeederResponse> getAllByFeederGroupIdAndStatus(Integer feederGroupId);
}
