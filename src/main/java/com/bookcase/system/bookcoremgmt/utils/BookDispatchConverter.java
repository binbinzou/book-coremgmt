/**
 * Project Name:book-coremgmt
 * File Name:BookDispatchConverter.java
 * Package Name:com.bookcase.system.bookcoremgmt.utils
 * Date:2017年6月4日下午3:50:06
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.utils;

import com.bookcase.system.bookcoremgmt.domain.CoredataBookdispatch;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqBody;
import com.bookcase.system.bookcoremgmt.otd.bookdispatch.BookDispatchRspBody;

/**
 * ClassName:BookDispatchConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午3:50:06 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookDispatchConverter {

	public static BookDispatchRspBody coredataBookdispatch2BookDispatchRspBody(
			CoredataBookdispatch coredataBookdispatch) {
		BookDispatchRspBody rspBody = new BookDispatchRspBody();
		rspBody.setBookcaseFromid(coredataBookdispatch.getBookcaseFromid());
		rspBody.setBookcaseToid(coredataBookdispatch.getBookcaseToid());
		rspBody.setBookmsgId(coredataBookdispatch.getBookmsgId());
		rspBody.setCarrier(coredataBookdispatch.getCarrier());
		rspBody.setCreateTime(coredataBookdispatch.getCreateTime());
		rspBody.setCreator(coredataBookdispatch.getCreator());
		rspBody.setId(coredataBookdispatch.getId());
		rspBody.setMessage(coredataBookdispatch.getMessage());
		rspBody.setProposer(coredataBookdispatch.getProposer());
		rspBody.setStatus(coredataBookdispatch.getStatus());
		rspBody.setType(coredataBookdispatch.getType());
		rspBody.setUpdateTime(coredataBookdispatch.getUpdateTime());
		return rspBody;
	}

	public static CoredataBookdispatch bookDispatchReqBody2CoredataBookdispatch(
			BookDispatchReqBody bookDispatchReqBody) {
		CoredataBookdispatch bookdispatch = new CoredataBookdispatch();
		bookdispatch.setBookcaseFromid(bookDispatchReqBody.getBookcaseFromid());
		bookdispatch.setBookcaseToid(bookDispatchReqBody.getBookcaseToid());
		bookdispatch.setBookmsgId(bookDispatchReqBody.getBookmsgId());
		bookdispatch.setCarrier(bookDispatchReqBody.getCarrier());
		bookdispatch.setMessage(bookDispatchReqBody.getMessage());
		bookdispatch.setProposer(bookDispatchReqBody.getProposer());
		bookdispatch.setType(bookDispatchReqBody.getType());
		// TODO Auto-generated method stub
		return bookdispatch;
	}

}

