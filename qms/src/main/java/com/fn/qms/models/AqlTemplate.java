package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pqc_template_aql database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_template_aql")
@NamedQuery(name = "AqlTemplate.findAll", query = "SELECT p FROM AqlTemplate p")
public class AqlTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "test_level")
	private String testLevel;

	@Column(name = "acceptance_level")
	private String acceptanceLevel;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "allowed_error")
	private String allowedError;

	@Column(name = "note")
	private String note;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;


	public AqlTemplate() {
	}
	
	@PrePersist
	public void onCreate() {
		createdAt = updatedAt = new Date();
	}
	
	@PreUpdate
	public void update() {
		updatedAt = new Date();
	}
}