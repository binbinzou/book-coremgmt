/**
 * Project Name:book-coremgmt
 * File Name:BookcommentConverter.java
 * Package Name:com.bookcase.system.bookcoremgmt.utils
 * Date:2017年6月4日下午3:18:01
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.utils;

import com.bookcase.system.bookcoremgmt.domain.CoredataBookcomment;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqBody;
import com.bookcase.system.bookcoremgmt.otd.bookcomment.BookCommentRspBody;

/**
 * ClassName:BookcommentConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午3:18:01 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookcommentConverter {

	public static BookCommentRspBody coredataBookcomment2BookCommentRspBody(
			CoredataBookcomment coredataBookcomment) {
		BookCommentRspBody rspBody = new BookCommentRspBody();
		rspBody.setBookCommonmsgId(coredataBookcomment.getBookCommonmsgId());
		rspBody.setContent(coredataBookcomment.getContent());
		rspBody.setCreateTime(coredataBookcomment.getCreateTime());
		rspBody.setCreator(coredataBookcomment.getCreator());
		rspBody.setId(coredataBookcomment.getId());
		rspBody.setScore(coredataBookcomment.getScore());
		rspBody.setStatus(coredataBookcomment.getStatus());
		rspBody.setUsefullCnt(coredataBookcomment.getUsefullCnt());
		return rspBody;
	}

	public static CoredataBookcomment bookCommentReqBody2CoredataBookcomment(
			BookCommentReqBody bookCommentReqBody) {
		CoredataBookcomment bookcomment = new CoredataBookcomment();
		bookcomment.setBookCommonmsgId(bookCommentReqBody.getBookCommonmsgId());
		bookcomment.setContent(bookCommentReqBody.getContent());
		bookcomment.setScore(bookCommentReqBody.getScore());
		bookcomment.setUsefullCnt(bookCommentReqBody.getUsefullCnt());
		return bookcomment;
	}

}

