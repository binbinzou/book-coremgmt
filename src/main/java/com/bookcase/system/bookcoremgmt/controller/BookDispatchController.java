/**
 * Project Name:book-coredatemgmt
 * File Name:BookDispatchController.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.controller
 * Date:2017年5月23日上午8:06:45
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
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookdispatch.BookDispatchRspBody;
import com.bookcase.system.bookcoremgmt.service.BookDispatchService;

/**
 * ClassName:BookDispatchController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:06:45 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="书调度信息")
@RestController
@Slf4j
public class BookDispatchController {

	@Autowired
	BookDispatchService dispatchService;

	@RequestMapping(value = "/auth/bookdispatchs/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询书调度信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookDispatchRspBody>> findBookDispatchs(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookDispatchRspBody>> result = dispatchService
				.findBookDispatchs(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询书调度信息(todo)")
	@RequestMapping(value = "/auth/bookdispatchs/{bookDispatchId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookDispatchId", dataType = "String", required = true, value = "书评论信息Id", defaultValue = "") })
	public GeneralContentResult<BookDispatchRspBody> findBookDispatchById(
			@PathVariable("bookDispatchId") String bookDispatchId) {
		GeneralContentResult<BookDispatchRspBody> result = dispatchService
				.findBookDispatchById(bookDispatchId);
		return result;
	}

	@ApiOperation(value = "创建书调度信息(todo)")
	@RequestMapping(value = "/auth/bookdispatchs", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookDispatch(
			@RequestBody BookDispatchReqBody BookDispatchReqBody) {
		GeneralContentResult<String> result = dispatchService
				.createBookDispatch(BookDispatchReqBody);
		return result;
	}

	@ApiOperation(value = "更新书评论信息(todo)")
	@RequestMapping(value = "/auth/BookDispatchs/{bookDispatchId}", method = RequestMethod.PUT)
	public GeneralResult updateBookDispatch(
			@PathVariable("bookDispatchId") String bookDispatchId,
			@RequestBody BookDispatchReqBody BookDispatchReqBody) {
		GeneralResult result = dispatchService
				.updateBookDispatch(bookDispatchId,
						BookDispatchReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除书评论信息(todo)")
	@RequestMapping(value = "/auth/BookDispatchs", method = RequestMethod.DELETE)
	public GeneralResult deleteBookDispatchs(
			@RequestBody BookDispatchReqParam BookDispatchReqParam) {
		GeneralResult result = dispatchService
				.deleteBookDispatchs(BookDispatchReqParam);
		return result;
	}
	
}

