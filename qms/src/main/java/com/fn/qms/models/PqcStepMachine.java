package com.fn.qms.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the iqc_audit_criteria_lkdt database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_step_machine")
@NamedQuery(name="PqcStepMachine.findAll", query="SELECT i FROM PqcStepMachine i")
public class PqcStepMachine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private long name;

	@Column(name="step_code")
	private String stepCode;

	@Column(name="lst_machine")
	private String lstMachine;

}