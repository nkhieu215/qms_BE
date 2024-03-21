package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "report_store_view")
public class ReportStoreView {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "lot")
    private String lot;

    @Column(name = "check_person")
    private String checkPerson;

    @Column(name = "check_date")
    private String checkDate;

    @Column(name = "quatity")
    private String quatity;

    @Column(name = "quatity_store")
    private String quatityStore;

    @Column(name = "total_err")
    private String totalErr;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "work_order_id")
    private Integer workOrderId;

    @Column(name = "conclude")
    private String conclude;

    @Column(name = "status")
    private Integer status;

    @Column(name = "note")
    private String note;
    @Column(name = "sap_wo")
    private String sapWo;

    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "planing_work_order_code")
    private String planingWorkOrderCode;

    @Column(name = "production_name")
    private String productionName;

    @Column(name = "production_code")
    private String productionCode;

    @Column(name = "purchase_order_code")
    private String purchaseOrderCode;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "quantity_plan")
    private String quantityPlan;


    @Column(name = "bom_version")
    private String bomVersion;

    @Column(name = "quantity_store_sap")
    private String quantityStoreSap;

    @Column(name = "total_error")
    private String totalError;
    @Column(name = "wo_id")
    private String woId;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
}
