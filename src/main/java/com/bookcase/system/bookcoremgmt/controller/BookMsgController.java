/**
 * Project Name:book-coredatemgmt
 * File Name:BookMsgController.java
 * Package Name:com.bookmsg.system.bookcoredatamgmt.controller
 * Date:2017年5月23日上午8:08:50
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

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
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;
import com.bookcase.system.bookcoremgmt.service.BookMsgService;

/**
 * ClassName:BookMsgController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:08:50 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="书本信息")
@RestController
@Slf4j
public class BookMsgController {

	@Autowired
	BookMsgService bookMsgService;

	@RequestMapping(value = "/auth/bookmsgs/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询书本信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookMsgRspBody>> findBookMsgs(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookMsgRspBody>> result = bookMsgService
				.findBookMsgs(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询书本信息(todo)")
	@RequestMapping(value = "/auth/bookmsgs/{bookmsgId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookmsgId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookMsgRspBody> findBookMsgById(
			@PathVariable("bookmsgId") String bookmsgId) {
		GeneralContentResult<BookMsgRspBody> result = bookMsgService
				.findBookMsgById(bookmsgId);
		return result;
	}

	@ApiOperation(value = "创建书本信息(todo)")
	@RequestMapping(value = "/auth/bookmsgs", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookMsg(
			@RequestBody BookMsgReqBody bookMsgReqBody) {
		GeneralContentResult<String> result = bookMsgService
				.createBookMsg(bookMsgReqBody);
		return result;
	}

	@ApiOperation(value = "更新书本信息(todo)")
	@RequestMapping(value = "/auth/bookmsgs/{bookmsgId}", method = RequestMethod.PUT)
	public GeneralResult updateBookMsg(
			@PathVariable("bookmsgId") String bookmsgId,
			@RequestBody BookMsgReqBody bookMsgReqBody) {
		GeneralResult result = bookMsgService
				.updateBookMsg(bookmsgId,
						bookMsgReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除书本信息(todo)")
	@RequestMapping(value = "/auth/bookmsgs", method = RequestMethod.DELETE)
	public GeneralResult deleteBookMsgs(
			@RequestBody BookMsgReqParam bookMsgReqParam) {
		GeneralResult result = bookMsgService
				.deleteBookMsgs(bookMsgReqParam);
		return result;
	}
	
}

