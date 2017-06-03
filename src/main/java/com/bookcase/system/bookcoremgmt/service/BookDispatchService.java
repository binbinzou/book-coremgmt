/**
 * Project Name:book-coredatemgmt
 * File Name:BookDispatchService.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service
 * Date:2017年5月23日上午8:07:15
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookdispatch.BookDispatchRspBody;

/**
 * ClassName:BookDispatchService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:07:15 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookDispatchService {

	GeneralPagingResult<List<BookDispatchRspBody>> findBookDispatchs(
			String page, String size);

	GeneralContentResult<BookDispatchRspBody> findBookDispatchById(
			String bookDispatchId);

	GeneralContentResult<String> createBookDispatch(
			BookDispatchReqBody bookDispatchReqBody);

	GeneralResult updateBookDispatch(String bookDispatchId,
			BookDispatchReqBody bookDispatchReqBody);

	GeneralResult deleteBookDispatchs(BookDispatchReqParam bookDispatchReqParam);

}

