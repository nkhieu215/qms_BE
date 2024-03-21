package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_err database table.
 * 
 */
@Setter
@Getter
@Entity
@Table(name="pqc_store_err")
@NamedQuery(name="PqcStoreErr.findAll", query="SELECT p FROM PqcStoreErr p")
public class PqcStoreErr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="check_person")
	private String checkPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String err;

	@Column(name="gr_err")
	private String grErr;

	private String line;

	private String quatity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="store_check_id")
	private Long storeCheckId;
	@Column(name="lot")
	private String lot;
	@Column(name="note")
	private String note;
	
	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	public PqcStoreErr() {
	}

}