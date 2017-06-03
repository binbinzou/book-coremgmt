/**
 * Project Name:book-coredatemgmt
 * File Name:BookCommentServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:05:41
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcomment.BookCommentRspBody;
import com.bookcase.system.bookcoremgmt.service.BookCommentService;

/**
 * ClassName:BookCommentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:05:41 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCommentServiceImpl implements BookCommentService {

	@Override
	public GeneralPagingResult<List<BookCommentRspBody>> findBookComments(
			String page, String size) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<BookCommentRspBody> findBookCommentById(
			String bookCommentId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralContentResult<String> createBookComment(
			BookCommentReqBody bookCommentReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult updateBookComment(String bookCommentId,
			BookCommentReqBody bookCommentReqBody) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralResult deleteBookComments(
			BookCommentReqParam bookCommentReqParam) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

