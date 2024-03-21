package com.fn.qms.models;

import com.fn.rd.models.ErrorList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "error")
@NamedQuery(name = "Error.findAll", query = "SELECT r FROM Error r")
public class Error {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "label")
    private String label;

    @Column(name = "id_error")
    private String idError;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void create() {
        updatedAt = createdAt = new Date();
    }

    @ManyToMany(mappedBy = "errLst")
    List<ErrorGroup> lstErrGr = new ArrayList<>();


}
