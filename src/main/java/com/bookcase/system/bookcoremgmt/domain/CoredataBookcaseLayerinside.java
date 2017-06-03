package com.bookcase.system.bookcoremgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the coredata_bookcase_layerinside database table.
 * 
 */
@Entity
@Table(name="coredata_bookcase_layerinside")
@NamedQuery(name="CoredataBookcaseLayerinside.findAll", query="SELECT c FROM CoredataBookcaseLayerinside c")
public class CoredataBookcaseLayerinside implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOKCASE_ID")
	private String bookcaseId;

	@Column(name="BOOKCASE_LAYERINSIDESIZE_ID")
	private String bookcaseLayerinsidesizeId;

	@Column(name="BOX_X")
	private float boxX;

	@Column(name="BOX_Y")
	private float boxY;

	@Column(name="BOX_Z")
	private float boxZ;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="ORG_ID")
	private String orgId;

	@Column(name="STATUS")
	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public CoredataBookcaseLayerinside() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookcaseId() {
		return this.bookcaseId;
	}

	public void setBookcaseId(String bookcaseId) {
		this.bookcaseId = bookcaseId;
	}

	public String getBookcaseLayerinsidesizeId() {
		return this.bookcaseLayerinsidesizeId;
	}

	public void setBookcaseLayerinsidesizeId(String bookcaseLayerinsidesizeId) {
		this.bookcaseLayerinsidesizeId = bookcaseLayerinsidesizeId;
	}

	public float getBoxX() {
		return this.boxX;
	}

	public void setBoxX(float boxX) {
		this.boxX = boxX;
	}

	public float getBoxY() {
		return this.boxY;
	}

	public void setBoxY(float boxY) {
		this.boxY = boxY;
	}

	public float getBoxZ() {
		return this.boxZ;
	}

	public void setBoxZ(float boxZ) {
		this.boxZ = boxZ;
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

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}