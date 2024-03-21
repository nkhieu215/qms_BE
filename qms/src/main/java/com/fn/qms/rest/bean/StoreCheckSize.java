package com.fn.qms.rest.bean;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_size database table.
 * 
 */
@Setter
@Getter
@Entity
@Table(name="pqc_store_size")
@NamedQuery(name="PqcStoreSize.findAll", query="SELECT p FROM PqcStoreSize p")
public class StoreCheckSize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="check_person")
	private String checkPerson;

	private String conclude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String note;

	private String quatity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="work_order_id")
	private int workOrderId;

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}
	
	@Column(name="store_check_id")
	private Long storeCheckId;

	
	public StoreCheckSize() {
	}

}