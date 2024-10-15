package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "pqc_bom_quantity")
public class PqcBomQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "total_error")
    private Integer totalError;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updateAt;
    @Column(name = "pqc_work_order_id")
    private Integer pqcWorkOrderId;
    @Column(name = "pqc_bom_work_order_id")
    private Integer pqcBomWorkOrderId;
}
