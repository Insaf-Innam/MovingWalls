package com.movingwalls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "finance", catalog = "movingwalls")
public class Finance implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Approvalstatus approvalstatus;
	private Tours tours;
	private String fmanagerUserName;

	public Finance() {

	}

	public Finance(Approvalstatus approvalstatus, Tours tours) {
		this.approvalstatus = approvalstatus;
		this.tours = tours;
	}

	public Finance(Approvalstatus approvalstatus, Tours tours, String fmanagerUserName) {
		this.approvalstatus = approvalstatus;
		this.tours = tours;
		this.fmanagerUserName = fmanagerUserName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Approvalstatus_id", nullable = false)
	public Approvalstatus getApprovalstatus() {
		return this.approvalstatus;
	}

	public void setApprovalstatus(Approvalstatus approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tours_id", nullable = false)
	public Tours getTours() {
		return this.tours;
	}

	public void setTours(Tours tours) {
		this.tours = tours;
	}

	@Column(name = "fManagerUserName", length = 45)
	public String getFmanagerUserName() {
		return this.fmanagerUserName;
	}

	public void setFmanagerUserName(String fmanagerUserName) {
		this.fmanagerUserName = fmanagerUserName;
	}

}
