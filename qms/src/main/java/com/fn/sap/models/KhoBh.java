/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fn.sap.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Dong
 */
@Entity
@Table(name = "[@KHO_BH]")
@XmlRootElement
@Getter
@Setter
public class KhoBh implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
}