package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "testing_critical")
public class TestingCritical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "testing_name")
    private String testingName;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "update_at")
    private String updateAt;
    @Column(name = "username")
    private String username;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
    @Column(name = "note")
    private String note;
    @Column(name = "testing_group_id")
    private Integer testingGroupId;
}
