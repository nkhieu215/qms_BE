package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the roles database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="setting")
@NamedQuery(name="Setting.findAll", query="SELECT r FROM Setting r")
public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String code;
	private String key;

	@Column(name = "approve")
	private String checkApprove;
}