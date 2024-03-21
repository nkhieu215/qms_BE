package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "report_error_all")
@NamedQuery(name="ReportErrorAll.findAll", query="SELECT r FROM ReportErrorAll r")
public class ReportErrorAll implements Serializable {
    @Column(name = "work_order_id")
    private String workOrderId;

    @Column(name = "production_code")
    private String productionCode;

    @Column(name = "planing_work_order_code")
    private String planingWorkOrderCode;

    @Column(name = "purchase_order_code")
    private String purchaseOrderCode;

    @Column(name = "bom_version")
    private String bomVersion;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "planing_work_order_id")
    private Integer planingWorkOrderId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "production_name")
    private String productionName;

    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "quantity_plan")
    private String quantityPlan;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "profile_code")
    private String profileCode;

    @Column(name = "sap_wo")
    private String sapWo;

    @Column(name = "doc_url")
    private String docUrl;

    @Column(name = "doc_url2")
    private String docUrl2;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "dt")
    private String dt;

    @Column(name = "date_create")
    private java.sql.Timestamp dateCreate;

    @Column(name = "err_group")
    private String errGroup;

    @Column(name = "err_name")
    private String errName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "ratio")
    private String ratio;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "dttd_type")
    private String dttdType;
}
