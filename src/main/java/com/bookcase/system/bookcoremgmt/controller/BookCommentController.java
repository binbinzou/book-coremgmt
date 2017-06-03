/**
 * Project Name:book-coredatemgmt
 * File Name:BookCommentController.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.controller
 * Date:2017年5月23日上午8:03:45
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcomment.BookCommentRspBody;
import com.bookcase.system.bookcoremgmt.service.BookCommentService;


/**
 * ClassName:BookCommentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:03:45 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="书评论信息")
@RestController
@Slf4j
public class BookCommentController {

	@Autowired
	BookCommentService commentService;

	@RequestMapping(value = "/auth/bookcomments/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询书评论信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCommentRspBody>> findBookComments(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCommentRspBody>> result = commentService
				.findBookComments(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询书评论信息(todo)")
	@RequestMapping(value = "/auth/bookcomments/{bookCommentId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCommentId", dataType = "String", required = true, value = "书评论信息Id", defaultValue = "") })
	public GeneralContentResult<BookCommentRspBody> findBookCommentById(
			@PathVariable("bookCommentId") String bookCommentId) {
		GeneralContentResult<BookCommentRspBody> result = commentService
				.findBookCommentById(bookCommentId);
		return result;
	}

	@ApiOperation(value = "创建书评论信息(todo)")
	@RequestMapping(value = "/auth/bookcomments", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookComment(
			@RequestBody BookCommentReqBody bookCommentReqBody) {
		GeneralContentResult<String> result = commentService
				.createBookComment(bookCommentReqBody);
		return result;
	}

	@ApiOperation(value = "更新书评论信息(todo)")
	@RequestMapping(value = "/auth/bookcomments/{bookCommentId}", method = RequestMethod.PUT)
	public GeneralResult updateBookComment(
			@PathVariable("bookCommentId") String bookCommentId,
			@RequestBody BookCommentReqBody bookCommentReqBody) {
		GeneralResult result = commentService
				.updateBookComment(bookCommentId,
						bookCommentReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除书评论信息(todo)")
	@RequestMapping(value = "/auth/bookcomments", method = RequestMethod.DELETE)
	public GeneralResult deleteBookComments(
			@RequestBody BookCommentReqParam bookCommentReqParam) {
		GeneralResult result = commentService
				.deleteBookComments(bookCommentReqParam);
		return result;
	}
	
}

