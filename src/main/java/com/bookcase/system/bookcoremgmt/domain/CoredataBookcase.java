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
 * The persistent class for the coredata_bookcase database table.
 * 
 */
@Entity
@Table(name="coredata_bookcase")
@NamedQuery(name="CoredataBookcase.findAll", query="SELECT c FROM CoredataBookcase c")
public class CoredataBookcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BEGINUSE_TIME")
	private Timestamp beginuseTime;

	@Column(name="BOOKCASE_TYPE_ID")
	private String bookcaseTypeId;

	@Column(name="CITY")
	private String city;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="DISTRICT")
	private String district;

	@Column(name="LAT")
	private String lat;

	@Column(name="LNG")
	private String lng;

	@Column(name="NAME")
	private String name;

	@Column(name="ORG_ID")
	private String orgId;

	@Column(name="PROVINCE")
	private String province;

	@Column(name="STATUS")
	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public CoredataBookcase() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getBeginuseTime() {
		return this.beginuseTime;
	}

	public void setBeginuseTime(Timestamp beginuseTime) {
		this.beginuseTime = beginuseTime;
	}

	public String getBookcaseTypeId() {
		return this.bookcaseTypeId;
	}

	public void setBookcaseTypeId(String bookcaseTypeId) {
		this.bookcaseTypeId = bookcaseTypeId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
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