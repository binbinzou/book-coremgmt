/**
 * Project Name:book-coremgmt
 * File Name:BookMsgConverter.java
 * Package Name:com.bookcase.system.bookcoremgmt.utils
 * Date:2017年6月4日下午4:10:02
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.utils;

import com.bookcase.system.bookcoremgmt.domain.CoredataBookmsg;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqBody;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;

/**
 * ClassName:BookMsgConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:10:02 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookMsgConverter {

	public static BookMsgRspBody coredataBookmsg2BookMsgRspBody(
			CoredataBookmsg coredataBookmsg) {
		BookMsgRspBody rspBody = new BookMsgRspBody();
		rspBody.setBookCommonmsgId(coredataBookmsg.getBookCommonmsgId());
		rspBody.setBooklendOrderid(coredataBookmsg.getBooklendOrderid());
		rspBody.setCreateTime(coredataBookmsg.getCreateTime());
		rspBody.setCreator(coredataBookmsg.getCreator());
		rspBody.setDeposit(coredataBookmsg.getDeposit());
		rspBody.setFirstBookcaseId(coredataBookmsg.getFirstBookcaseId());
		rspBody.setId(coredataBookmsg.getId());
		rspBody.setLendUserid(coredataBookmsg.getLendUserid());
		rspBody.setOnedayPriiceOverdue(coredataBookmsg.getOnedayPriiceOverdue());
		rspBody.setOnedayPriiceUnoverdue(coredataBookmsg.getOnedayPriiceUnoverdue());
		rspBody.setRealBookcaseId(coredataBookmsg.getRealBookcaseId());
		rspBody.setReNewday(coredataBookmsg.getReNewday());
		rspBody.setRentUserid(coredataBookmsg.getRentUserid());
		rspBody.setStatus(coredataBookmsg.getStatus());
		rspBody.setUnoverdueMaxday(coredataBookmsg.getUnoverdueMaxday());
		rspBody.setUpdateTime(coredataBookmsg.getUpdateTime());
		return rspBody;
	}

	public static CoredataBookmsg bookMsgReqBody2CoredataBookmsg(
			BookMsgReqBody bookMsgReqBody) {
		CoredataBookmsg bookmsg = new CoredataBookmsg();
		bookmsg.setBookCommonmsgId(bookMsgReqBody.getBookCommonmsgId());
		bookmsg.setBooklendOrderid(bookMsgReqBody.getBooklendOrderid());
		bookmsg.setDeposit(bookMsgReqBody.getDeposit());
		bookmsg.setFirstBookcaseId(bookMsgReqBody.getFirstBookcaseId());
		bookmsg.setLendUserid(bookMsgReqBody.getLendUserid());
		bookmsg.setOnedayPriiceOverdue(bookMsgReqBody.getOnedayPriiceOverdue());
		bookmsg.setOnedayPriiceUnoverdue(bookMsgReqBody.getOnedayPriiceUnoverdue());
		bookmsg.setRealBookcaseId(bookMsgReqBody.getRealBookcaseId());
		bookmsg.setReNewday(bookMsgReqBody.getReNewday());
		bookmsg.setRentUserid(bookMsgReqBody.getRentUserid());
		bookmsg.setUnoverdueMaxday(bookMsgReqBody.getUnoverdueMaxday());
		return bookmsg;
	}

}

