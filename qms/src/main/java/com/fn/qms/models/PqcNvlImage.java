package com.fn.qms.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name="pqc_draw_nvl_img")
@NamedQuery(name="PqcNvlImage.findAll", query="SELECT p FROM PqcNvlImage p")
public class PqcNvlImage {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="url_path")
	private String urlPath;
	
	@Column(name="pqc_draw_nvl_id")
	private Long pqcDrawNvlId;

	@Column(name="wo_id")
	private Long woId;

	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@PrePersist
	void createdAt() {
		this.createdAt = this.updatedAt = new Date();
	}
	
}
