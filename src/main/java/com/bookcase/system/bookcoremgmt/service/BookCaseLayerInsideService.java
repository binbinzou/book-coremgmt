/**
 * Project Name:book-coredatemgmt
 * File Name:BookTypeLayerInsideService.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service
 * Date:2017年5月23日上午8:11:33
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcaselayerinside.BookCaseLayerInsideRspBody;

/**
 * ClassName:BookTypeLayerInsideService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:11:33 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookCaseLayerInsideService {

	GeneralPagingResult<List<BookCaseLayerInsideRspBody>> findBookCaseLayerInsides(
			String page, String size);

	GeneralContentResult<BookCaseLayerInsideRspBody> findBookCaseLayerInsideById(
			String bookCaseLayerInsideId);

	GeneralContentResult<String> createBookCaseLayerInside(
			BookCaseLayerInsideReqBody bookCaseReqBody);

	GeneralResult updateBookCaseLayerInside(String bookCaseLayerInsideId,
			BookCaseLayerInsideReqBody bookCaseReqBody);

	GeneralResult deleteBookCaseLayerInsides(
			BookCaseLayerInsideReqParam bookCaseReqParam);

}

