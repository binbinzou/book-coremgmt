/**
 * Project Name:book-coredatemgmt
 * File Name:BookMsgService.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service
 * Date:2017年5月23日上午8:09:24
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;

/**
 * ClassName:BookMsgService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:09:24 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookMsgService {

	GeneralPagingResult<List<BookMsgRspBody>> findBookMsgs(String page,
			String size);

	GeneralContentResult<BookMsgRspBody> findBookMsgById(String bookmsgId);

	GeneralContentResult<String> createBookMsg(BookMsgReqBody bookMsgReqBody);

	GeneralResult updateBookMsg(String bookmsgId, BookMsgReqBody bookMsgReqBody);

	GeneralResult deleteBookMsgs(BookMsgReqParam bookMsgReqParam);

}

