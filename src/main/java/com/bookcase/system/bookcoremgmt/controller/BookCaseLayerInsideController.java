/**
 * Project Name:book-coredatemgmt
 * File Name:BookTypeLayerInsideController.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.controller
 * Date:2017年5月23日上午8:10:37
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
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcaselayerinside.BookCaseLayerInsideRspBody;
import com.bookcase.system.bookcoremgmt.service.BookCaseLayerInsideService;

/**
 * ClassName:BookTypeLayerInsideController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:10:37 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="图书柜内部分层内部分层信息")
@RestController
@Slf4j
public class BookCaseLayerInsideController {

	@Autowired
	BookCaseLayerInsideService caseLayerInsideService;

	@RequestMapping(value = "/auth/bookcaselayerinsides/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询图书柜内部分层信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCaseLayerInsideRspBody>> findBookCaseLayerInsides(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCaseLayerInsideRspBody>> result = caseLayerInsideService
				.findBookCaseLayerInsides(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书柜内部分层信息(todo)")
	@RequestMapping(value = "/auth/bookcaselayerinsides/{bookCaseLayerInsideId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCaseLayerInsideId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookCaseLayerInsideRspBody> findBookCaseLayerInsideById(
			@PathVariable("bookCaseLayerInsideId") String bookCaseLayerInsideId) {
		GeneralContentResult<BookCaseLayerInsideRspBody> result = caseLayerInsideService
				.findBookCaseLayerInsideById(bookCaseLayerInsideId);
		return result;
	}

	@ApiOperation(value = "创建图书柜内部分层信息(todo)")
	@RequestMapping(value = "/auth/bookcaselayerinsides", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCaseLayerInside(
			@RequestBody BookCaseLayerInsideReqBody bookCaseReqBody) {
		GeneralContentResult<String> result = caseLayerInsideService
				.createBookCaseLayerInside(bookCaseReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书柜内部分层信息(todo)")
	@RequestMapping(value = "/auth/bookcaselayerinsides/{bookCaseLayerInsideId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCaseLayerInside(
			@PathVariable("bookCaseLayerInsideId") String bookCaseLayerInsideId,
			@RequestBody BookCaseLayerInsideReqBody bookCaseReqBody) {
		GeneralResult result = caseLayerInsideService
				.updateBookCaseLayerInside(bookCaseLayerInsideId,
						bookCaseReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书柜内部分层信息(todo)")
	@RequestMapping(value = "/auth/bookcaselayerinsides", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCaseLayerInsides(
			@RequestBody BookCaseLayerInsideReqParam bookCaseReqParam) {
		GeneralResult result = caseLayerInsideService
				.deleteBookCaseLayerInsides(bookCaseReqParam);
		return result;
	}
	
}

