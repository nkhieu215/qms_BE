package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "error_lst_gr")
@NamedQuery(name = "ErrorLstGr.findAll", query = "SELECT r FROM ErrorLstGr r")
public class ErrorLstGr {
    @Id
    @Column(name = "id_error")
    private Long idError;

    @Column(name = "id_err_gr")
    private Long idErrGr;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

}
