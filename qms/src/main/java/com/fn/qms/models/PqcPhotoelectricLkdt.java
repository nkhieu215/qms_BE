package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the pqc_photoelectric_lkdt database table.
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_photoelectric_lkdt")
@NamedQuery(name = "PqcPhotoelectricLkdt.findAll", query = "SELECT p FROM PqcPhotoelectricLkdt p")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PqcPhotoelectricLkdt {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "check_content")
    private String checkContent;

    @Column(name = "check_result")
    private String checkResult;

    @Column(name = "elect_comp_id")
    private int electCompId;

    private String inaccuracy;

    @Column(name = "audit_content")
    private String auditContent;
    @Column(name = "regulation_level")
    private String regulationLevel;
    @Column(name = "technical_requirement")
    private String technicalRequirement;

    @Column(name = "pqc_photoelectric_id")
    private Long pqcPhotoelectricId;

    private String quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    void createdAt() {
        this.createdAt = this.updatedAt = new Date();
    }

    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pqc_photoelectric_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"resultParam", "hibernateLazyInitializer", "handler"})

    private PqcPhotoelectric pqcPhotoelectric;

}