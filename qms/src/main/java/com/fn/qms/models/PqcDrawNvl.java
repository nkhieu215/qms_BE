package com.fn.qms.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fn.qms.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name="pqc_draw_nvl")
@NamedQuery(name="PqcDrawNvl.findAll", query="SELECT p FROM PqcDrawNvl p")
public class PqcDrawNvl {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="note")
	private String note;
	
	@Column(name="conclude")
	private String conclude;
	
	@Column(name="check_person")
	private String checkPerson;

	@Column(name="work_order_id")
	private Long workOrderId;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;	

	@Transient
	String createdAtStr;

	public void setCreatedAtStr(String createdAtStr) {
		if(createdAt != null){
			this.createdAtStr = DateUtils.convertToDateString(this.createdAt, DateUtils.DATE_WITH_DASH2);
		}

	}

	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}

	@OneToMany(mappedBy = "drawNvlCheck", cascade = CascadeType.PERSIST,orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PqcDrawTestNvl> lstPqcDrawNvl;

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;
	
}
