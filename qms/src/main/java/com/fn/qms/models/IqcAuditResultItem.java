package com.fn.qms.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "iqc_audit_result_item")
public class IqcAuditResultItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "bill_number")
    private String billNumber;
    @Column(name = "lot_number")
    private String lotNumber;
    @Column(name = "po_quantity")
    private Integer poQuantity;
    @Column(name = "quantity_check")
    private Integer quantityCheck;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "update_at")
    private String updateAt;
    @Column(name = "username")
    private String username;
    @Column(name = "note")
    private String note;
    @Column(name = "iqc_elec_comp_id")
    private Integer iqcElecCompId;
}
