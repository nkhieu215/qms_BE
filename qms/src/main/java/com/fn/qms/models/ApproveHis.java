package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "approve_his")
public class ApproveHis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "approve_status")
    private String approveStatus;

    @Column(name = "note")
    private String note;

    @Column(name = "check_id")
    private Long checkId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    void onCreate(){
        this.createdAt = this.updatedAt = new Date();
    }
}
