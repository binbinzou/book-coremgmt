/**
 * Project Name:book-coredatemgmt
 * File Name:BookDispatchServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:07:43
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookdispatch.BookDispatchRspBody;
import com.bookcase.system.bookcoremgmt.service.BookDispatchService;

/**
 * ClassName:BookDispatchServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:07:43 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookDispatchServiceImpl implements BookDispatchService {

	@Override
	public GeneralPagingResult<List<BookDispatchRspBody>> findBookDispatchs(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookDispatchRspBody> findBookDispatchById(
			String bookDispatchId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookDispatch(
			BookDispatchReqBody bookDispatchReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookDispatch(String bookDispatchId,
			BookDispatchReqBody bookDispatchReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookDispatchs(
			BookDispatchReqParam bookDispatchReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

