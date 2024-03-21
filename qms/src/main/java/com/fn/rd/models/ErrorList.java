package com.fn.rd.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fn.qms.models.Menu;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="error_list")
@NamedQuery(name="ErrorList.findAll", query="SELECT e FROM ErrorList e")
public class ErrorList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="parent_id")
	private Long parentId;

	@Column(name="type")
	private Integer type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="error_code")
	private String errorCode;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
	@Fetch(value = FetchMode.SUBSELECT)
    private List<ErrorList> errChild = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}
}