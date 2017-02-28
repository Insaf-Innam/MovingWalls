package com.movingwalls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "approvalstatus", catalog = "movingwalls")
public class Approvalstatus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String statusType;

	public Approvalstatus() {

	}

	public Approvalstatus(String statusType) {
		this.statusType = statusType;
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

	@Column(name = "statusType", length = 45)
	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

}
