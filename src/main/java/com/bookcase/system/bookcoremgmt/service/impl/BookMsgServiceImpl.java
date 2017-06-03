/**
 * Project Name:book-coredatemgmt
 * File Name:BookMsgServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:09:58
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service.impl;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;
import com.bookcase.system.bookcoremgmt.service.BookMsgService;

/**
 * ClassName:BookMsgServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:09:58 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookMsgServiceImpl implements BookMsgService {

	@Override
	public GeneralPagingResult<List<BookMsgRspBody>> findBookMsgs(String page,
			String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookMsgRspBody> findBookMsgById(String bookmsgId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookMsg(
			BookMsgReqBody bookMsgReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookMsg(String bookmsgId,
			BookMsgReqBody bookMsgReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookMsgs(BookMsgReqParam bookMsgReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

