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
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookcoremgmt.service.BookCaseService;


@Api(value="图书柜信息")
@RestController
@Slf4j
public class BookCaseController {

	@Autowired
	BookCaseService bookCaseService;

	@RequestMapping(value = "/auth/bookcases/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询图书柜信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCaseRspBody>> findBookCases(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCaseRspBody>> result = bookCaseService
				.findBookCases(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书柜信息(todo)")
	@RequestMapping(value = "/auth/bookcases/{bookcaseId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookcaseId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookCaseRspBody> findBookCaseById(
			@PathVariable("bookcaseId") String bookcaseId) {
		GeneralContentResult<BookCaseRspBody> result = bookCaseService
				.findBookCaseById(bookcaseId);
		return result;
	}

	@ApiOperation(value = "创建图书柜信息(todo)")
	@RequestMapping(value = "/auth/bookcases", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCase(
			@RequestBody BookCaseReqBody bookCaseReqBody) {
		GeneralContentResult<String> result = bookCaseService
				.createBookCase(bookCaseReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书柜信息(todo)")
	@RequestMapping(value = "/auth/bookcases/{bookcaseId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCase(
			@PathVariable("bookcaseId") String bookcaseId,
			@RequestBody BookCaseReqBody bookCaseReqBody) {
		GeneralResult result = bookCaseService
				.updateBookCase(bookcaseId,
						bookCaseReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书柜信息(todo)")
	@RequestMapping(value = "/auth/bookcases", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCases(
			@RequestBody BookCaseReqParam bookCaseReqParam) {
		GeneralResult result = bookCaseService
				.deleteBookCases(bookCaseReqParam);
		return result;
	}
	
}
