package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "qr_feeder_history")
public class QrFeederHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "machine_code")
    private String machineCode;
    @Column(name = "main_qr_feeder")
    private String mainQrFeeder;
    @Column(name = "replace_qr_feeder")
    private String replaceQrFeeder;
    @Column(name = "time_update")
    private Date timeUpdate;
    @Column(name = "user")
    private String user;
}
