package com.movingwalls.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tours", catalog = "movingwalls")
public class Tours implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Approvalstatus approvalstatus;
	private User user;

	private String description;
	private Date startDate;
	private Date endDate;
	private String mode;
	private Double ticketCost;
	private Double homeCityCabCost;
	private Double destinationCityCabCost;
	private Double hotelCost;
	private String managerUserName;
	private String financeApproval;

	public Tours() {

	}

	public Tours(Approvalstatus approvalstatus, User user) {
		this.approvalstatus = approvalstatus;
		this.user = user;
	}

	public Tours(Approvalstatus approvalstatus, User user, String description, Date startDate, Date endDate,
			String mode, Double ticketCost, Double homeCityCabCost, Double destinationCityCabCost, Double hotelCost,
			String managerUserName, String financeApproval) {
		this.approvalstatus = approvalstatus;
		this.user = user;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mode = mode;
		this.ticketCost = ticketCost;
		this.homeCityCabCost = homeCityCabCost;
		this.destinationCityCabCost = destinationCityCabCost;
		this.hotelCost = hotelCost;
		this.managerUserName = managerUserName;
		this.financeApproval = financeApproval;
		
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
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "description", length = 90)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endDate", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "mode", length = 45)
	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Column(name = "ticketCost", precision = 22, scale = 0)
	public Double getTicketCost() {
		return this.ticketCost;
	}

	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Column(name = "homeCityCabCost", precision = 22, scale = 0)
	public Double getHomeCityCabCost() {
		return this.homeCityCabCost;
	}

	public void setHomeCityCabCost(Double homeCityCabCost) {
		this.homeCityCabCost = homeCityCabCost;
	}

	@Column(name = "destinationCityCabCost", precision = 22, scale = 0)
	public Double getDestinationCityCabCost() {
		return this.destinationCityCabCost;
	}

	public void setDestinationCityCabCost(Double destinationCityCabCost) {
		this.destinationCityCabCost = destinationCityCabCost;
	}

	@Column(name = "hotelCost", precision = 22, scale = 0)
	public Double getHotelCost() {
		return this.hotelCost;
	}

	public void setHotelCost(Double hotelCost) {
		this.hotelCost = hotelCost;
	}

	@Column(name = "managerUserName", length = 45)
	public String getManagerUserName() {
		return this.managerUserName;
	}

	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}

	@Column(name = "financeApproval", length = 45)
	public String getFinanceApproval() {
		return this.financeApproval;
	}

	public void setFinanceApproval(String financeApproval) {
		this.financeApproval = financeApproval;
	}

}
