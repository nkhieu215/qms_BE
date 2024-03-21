package com.fn.qms.models;

import com.fn.rd.models.ErrorList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "error_group")
@NamedQuery(name = "ErrorGroup.findAll", query = "SELECT r FROM ErrorGroup r")
public class ErrorGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_gr")
    private String idGr;

    @Column(name = "type")
    private String type;

    @Column(name = "label")
    private String label;

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

    @ManyToMany
    @JoinTable(
            name = "error_lst_gr",
            joinColumns = @JoinColumn(name = "id_err_gr"),
            inverseJoinColumns = @JoinColumn(name = "id_error")
    )
    private List<Error> errLst = new ArrayList<>();
}
