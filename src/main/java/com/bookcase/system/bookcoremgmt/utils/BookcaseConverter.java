/**
 * Project Name:book-coremgmt
 * File Name:CoredataBookcaseConverter.java
 * Package Name:com.bookcase.system.bookcoremgmt.utils
 * Date:2017年6月3日下午4:02:56
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.utils;

import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqBody;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;

/**
 * ClassName:CoredataBookcaseConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午4:02:56 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookcaseConverter {

	public static BookCaseRspBody coredataBookcase2BookCaseRspBody(
			CoredataBookcase coredataBookcase) {
		BookCaseRspBody rspBody = new BookCaseRspBody();
		rspBody.setBeginuseTime(coredataBookcase.getBeginuseTime());
		rspBody.setBookcaseTypeId(coredataBookcase.getBookcaseTypeId());
		rspBody.setCity(coredataBookcase.getCity());
		rspBody.setCreateTime(coredataBookcase.getCreateTime());
		rspBody.setCreator(coredataBookcase.getCreator());
		rspBody.setDistrict(coredataBookcase.getDistrict());
		rspBody.setId(coredataBookcase.getId());
		rspBody.setLat(coredataBookcase.getLat());
		rspBody.setLng(coredataBookcase.getLng());
		rspBody.setName(coredataBookcase.getName());
		rspBody.setOrgId(coredataBookcase.getOrgId());
		rspBody.setProvince(coredataBookcase.getProvince());
		rspBody.setStatus(coredataBookcase.getStatus());
		rspBody.setUpdateTime(coredataBookcase.getUpdateTime());
		return rspBody;
	}

	public static CoredataBookcase bookCaseReqBody2CoredataBookcase(
			BookCaseReqBody bookCaseReqBody) {
		CoredataBookcase bookcase = new CoredataBookcase();
		bookcase.setBeginuseTime(bookCaseReqBody.getBeginuseTime());
		bookcase.setBookcaseTypeId(bookCaseReqBody.getBookcaseTypeId());
		bookcase.setCity(bookCaseReqBody.getCity());
		bookcase.setDistrict(bookCaseReqBody.getDistrict());
		bookcase.setLat(bookCaseReqBody.getLat());
		bookcase.setLng(bookCaseReqBody.getLng());
		bookcase.setName(bookCaseReqBody.getName());
		bookcase.setProvince(bookCaseReqBody.getProvince());
		return bookcase;
	}

}

