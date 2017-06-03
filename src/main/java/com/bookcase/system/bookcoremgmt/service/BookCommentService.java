/**
 * Project Name:book-coredatemgmt
 * File Name:BookCommentService.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service
 * Date:2017年5月23日上午8:05:13
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcomment.BookCommentRspBody;

/**
 * ClassName:BookCommentService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:05:13 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookCommentService {

	GeneralPagingResult<List<BookCommentRspBody>> findBookComments(String page,
			String size);

	GeneralContentResult<BookCommentRspBody> findBookCommentById(
			String bookCommentId);

	GeneralContentResult<String> createBookComment(
			BookCommentReqBody bookCommentReqBody);

	GeneralResult updateBookComment(String bookCommentId,
			BookCommentReqBody bookCommentReqBody);

	GeneralResult deleteBookComments(BookCommentReqParam bookCommentReqParam);

}

