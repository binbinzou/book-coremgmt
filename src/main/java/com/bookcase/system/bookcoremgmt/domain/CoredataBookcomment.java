package com.bookcase.system.bookcoremgmt.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the coredata_bookcomment database table.
 * 
 */
@Entity
@Table(name="coredata_bookcomment")
@NamedQuery(name="CoredataBookcomment.findAll", query="SELECT c FROM CoredataBookcomment c")
public class CoredataBookcomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOK_COMMONMSG_ID")
	private String bookCommonmsgId;

	@Lob
	@Column(name="CONTENT")
	private String content;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="SCORE")
	private int score;

	@Column(name="STATUS")
	private short status;

	@Column(name="USEFULL_CNT")
	private short usefullCnt;

	public CoredataBookcomment() {
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public short getUsefullCnt() {
		return this.usefullCnt;
	}

	public void setUsefullCnt(short usefullCnt) {
		this.usefullCnt = usefullCnt;
	}

}