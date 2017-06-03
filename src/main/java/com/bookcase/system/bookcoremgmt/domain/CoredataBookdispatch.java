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
 * The persistent class for the coredata_bookdispatch database table.
 * 
 */
@Entity
@Table(name="coredata_bookdispatch")
@NamedQuery(name="CoredataBookdispatch.findAll", query="SELECT c FROM CoredataBookdispatch c")
public class CoredataBookdispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOKCASE_FROMID")
	private String bookcaseFromid;

	@Column(name="BOOKCASE_TOID")
	private String bookcaseToid;

	@Column(name="BOOKMSG_ID")
	private String bookmsgId;

	@Column(name="CARRIER")
	private String carrier;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="MESSAGE")
	private String message;

	@Column(name="PROPOSER")
	private String proposer;

	@Column(name="STATUS")
	private short status;

	@Column(name="TYPE")
	private short type;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public CoredataBookdispatch() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookcaseFromid() {
		return this.bookcaseFromid;
	}

	public void setBookcaseFromid(String bookcaseFromid) {
		this.bookcaseFromid = bookcaseFromid;
	}

	public String getBookcaseToid() {
		return this.bookcaseToid;
	}

	public void setBookcaseToid(String bookcaseToid) {
		this.bookcaseToid = bookcaseToid;
	}

	public String getBookmsgId() {
		return this.bookmsgId;
	}

	public void setBookmsgId(String bookmsgId) {
		this.bookmsgId = bookmsgId;
	}

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProposer() {
		return this.proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}