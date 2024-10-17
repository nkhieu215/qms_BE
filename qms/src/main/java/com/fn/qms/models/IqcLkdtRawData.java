package com.fn.qms.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "iqc_lkdt_raw_data")
public class IqcLkdtRawData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "iqc_elect_comp_id")
    private Integer iqcElectCompId;
    @Column(name = "data")
    private String data;
    @Column(name = "created_at")
    private Date createdAt;
}
