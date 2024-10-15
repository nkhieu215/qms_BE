package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "pqc_bom_error_detail")
public class PqcBomErrorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "error_code")
    private String errorCode;
    @Column(name = "error_name")
    private String errorName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "note")
    private String note;
    @Column(name = "pqc_bom_quantity_id")
    private Integer pqcBomQuantityId;
    @Column(name = "pqc_work_order_id")
    private Integer pqcWorkOrderId;
    @Column(name = "pqc_bom_work_order_id")
    private Integer pqcBomWorkOrderId;
}
