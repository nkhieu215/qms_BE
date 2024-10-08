package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "qr_feeder")
public class QrFeeder {
    @Id
    @Column(name = "qr_feeder_id")
    private Integer qrFeederId;
    @Column(name = "qr_feeder_code")
    private String qrFeederCode;
    @Column(name = "feeder_group_id")
    private String feederGroupId;
}
