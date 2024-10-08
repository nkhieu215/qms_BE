package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_scan_100")
@NamedQuery(name="PqcScan100.findAll", query="SELECT p FROM PqcScan100 p")
public class PqcScan100 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name="machine")
	private String machine;

	@Column(name="side")
	private String side;

	@Column(name="feeder")
	private String feeder;
	@Column(name="material")
	private String material;

	@Column(name="qr")
	private String qr;
	@Column(name="date")
	private String date;
	@Column(name="status")
	private Integer status;

	@Column(name="user_check")
	private String user_check;

	@Column(name = "work_order_id")
	private Long workOrderId;

	public PqcScan100() {
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "time_confirmed")
	private String timeConfirmed;
	@Column(name = "reason")
	private String reason;
	@Column(name = "confirm")
	private String confirm;

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "work_order_id", insertable = false, updatable = false)
	@JsonIgnore
	private PqcWorkOrder pqcWorkOrder;

	@Override
	public String toString() {
		return "PqcScan100{" +
				"id=" + id +
				", machine='" + machine + '\'' +
				", side='" + side + '\'' +
				", feeder='" + feeder + '\'' +
				", material='" + material + '\'' +
				", qr='" + qr + '\'' +
				", date='" + date + '\'' +
				", status=" + status +
				", user_check='" + user_check + '\'' +
				", workOrderId=" + workOrderId +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", timeConfirmed=" + timeConfirmed +
				", reason='" + reason + '\'' +
				", confirm='" + confirm + '\'' +
				", pqcWorkOrder=" + pqcWorkOrder +
				'}';
	}
}