/**
 * Project Name:book-coremgmt
 * File Name:BookcaseLayerinsideConverterConverter.java
 * Package Name:com.bookcase.system.bookcoremgmt.utils
 * Date:2017年6月3日下午6:08:12
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.utils;

import com.bookcase.system.bookcoremgmt.domain.CoredataBookcaseLayerinside;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqBody;
import com.bookcase.system.bookcoremgmt.otd.bookcaselayerinside.BookCaseLayerInsideRspBody;

/**
 * ClassName:BookcaseLayerinsideConverterConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午6:08:12 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookcaseLayerinsideConverter {

	public static BookCaseLayerInsideRspBody CoredataBookcaseLayerinside2BookCaseLayerInsideRspBody(
			CoredataBookcaseLayerinside layerinside) {
		BookCaseLayerInsideRspBody rspBody = new BookCaseLayerInsideRspBody();
		rspBody.setBookcaseId(layerinside.getBookcaseId());
		rspBody.setBookcaseLayerinsidesizeId(layerinside.getBookcaseLayerinsidesizeId());
		rspBody.setBoxX(layerinside.getBoxX());
		rspBody.setBoxY(layerinside.getBoxY());
		rspBody.setBoxZ(layerinside.getBoxZ());
		rspBody.setCreateTime(layerinside.getCreateTime());
		rspBody.setCreator(layerinside.getCreator());
		rspBody.setId(layerinside.getId());
		rspBody.setOrgId(layerinside.getOrgId());
		rspBody.setStatus(layerinside.getStatus());
		rspBody.setUpdateTime(layerinside.getUpdateTime());
		return rspBody;
	}

	public static CoredataBookcaseLayerinside bookCaseLayerInsideReqBody2CoredataBookcaseLayerinside(
			BookCaseLayerInsideReqBody layerInsideReqBody) {
		CoredataBookcaseLayerinside layerinside = new CoredataBookcaseLayerinside();
		layerinside.setBookcaseId(layerInsideReqBody.getBookcaseId());
		layerinside.setBookcaseLayerinsidesizeId(layerInsideReqBody.getBookcaseLayerinsidesizeId());
		layerinside.setBoxX(layerInsideReqBody.getBoxX());
		layerinside.setBoxY(layerInsideReqBody.getBoxY());
		layerinside.setBoxZ(layerInsideReqBody.getBoxZ());
		return layerinside;
	}

	
	
}

