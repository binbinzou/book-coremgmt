package com.bookcase.system.bookcoremgmt.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the coredata_bookmsg database table.
 * 
 */
@Entity
@Table(name="coredata_bookmsg")
@NamedQuery(name="CoredataBookmsg.findAll", query="SELECT c FROM CoredataBookmsg c")
public class CoredataBookmsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOK_COMMONMSG_ID")
	private String bookCommonmsgId;

	@Column(name="BOOKLEND_ORDERID")
	private String booklendOrderid;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="DEPOSIT")
	private float deposit;

	@Column(name="FIRST_BOOKCASE_ID")
	private String firstBookcaseId;

	@Column(name="LEND_USERID")
	private String lendUserid;

	@Column(name="ONEDAY_PRIICE_OVERDUE")
	private float onedayPriiceOverdue;

	@Column(name="ONEDAY_PRIICE_UNOVERDUE")
	private float onedayPriiceUnoverdue;

	@Column(name="RE_NEWDAY")
	private int reNewday;

	@Column(name="REAL_BOOKCASE_ID")
	private String realBookcaseId;

	@Column(name="RENT_USERID")
	private String rentUserid;

	@Column(name="STATUS")
	private short status;

	@Column(name="UNOVERDUE_MAXDAY")
	private int unoverdueMaxday;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public CoredataBookmsg() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookCommonmsgId() {
		return this.bookCommonmsgId;
	}

	public void setBookCommonmsgId(String bookCommonmsgId) {
		this.bookCommonmsgId = bookCommonmsgId;
	}

	public String getBooklendOrderid() {
		return this.booklendOrderid;
	}

	public void setBooklendOrderid(String booklendOrderid) {
		this.booklendOrderid = booklendOrderid;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public float getDeposit() {
		return this.deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public String getFirstBookcaseId() {
		return this.firstBookcaseId;
	}

	public void setFirstBookcaseId(String firstBookcaseId) {
		this.firstBookcaseId = firstBookcaseId;
	}

	public String getLendUserid() {
		return this.lendUserid;
	}

	public void setLendUserid(String lendUserid) {
		this.lendUserid = lendUserid;
	}

	public float getOnedayPriiceOverdue() {
		return this.onedayPriiceOverdue;
	}

	public void setOnedayPriiceOverdue(float onedayPriiceOverdue) {
		this.onedayPriiceOverdue = onedayPriiceOverdue;
	}

	public float getOnedayPriiceUnoverdue() {
		return this.onedayPriiceUnoverdue;
	}

	public void setOnedayPriiceUnoverdue(float onedayPriiceUnoverdue) {
		this.onedayPriiceUnoverdue = onedayPriiceUnoverdue;
	}

	public int getReNewday() {
		return this.reNewday;
	}

	public void setReNewday(int reNewday) {
		this.reNewday = reNewday;
	}

	public String getRealBookcaseId() {
		return this.realBookcaseId;
	}

	public void setRealBookcaseId(String realBookcaseId) {
		this.realBookcaseId = realBookcaseId;
	}

	public String getRentUserid() {
		return this.rentUserid;
	}

	public void setRentUserid(String rentUserid) {
		this.rentUserid = rentUserid;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getUnoverdueMaxday() {
		return this.unoverdueMaxday;
	}

	public void setUnoverdueMaxday(int unoverdueMaxday) {
		this.unoverdueMaxday = unoverdueMaxday;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}