package com.bookcase.system.bookcoremgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtResultConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqParam;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqQuery;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookcoremgmt.repository.CoredataBookCaseRepository;
import com.bookcase.system.bookcoremgmt.service.BookCaseService;
import com.bookcase.system.bookcoremgmt.utils.BookCaseConverter;

@Service
@Slf4j
public class BookCaseServiceImpl implements BookCaseService {

	@Autowired
	CoredataBookCaseRepository coredataBookCaseRepository;
	
	@Override
	public GeneralPagingResult<List<BookCaseRspBody>> findBookCases(BookCaseReqQuery query,
			String page, String size) {
		GeneralPagingResult<List<BookCaseRspBody>> result = new GeneralPagingResult<List<BookCaseRspBody>>();
		List<BookCaseRspBody> rspBodies = new ArrayList<BookCaseRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		String name = query.getName();
		Page<CoredataBookcase> pg = coredataBookCaseRepository
				.findBookCases(name,request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (CoredataBookcase coredataBookcase : pg.getContent()) {
				rspBodies.add(BookCaseConverter
								.coredataBookcase2BookCaseRspBody(coredataBookcase));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCaseRspBody> findBookCaseById(
			String bookcaseId) {
		GeneralContentResult<BookCaseRspBody> result = new GeneralContentResult<BookCaseRspBody>();
		CoredataBookcase bookcase  = coredataBookCaseRepository.findOne(bookcaseId);
		BookCaseRspBody rspBody = BookCaseConverter.coredataBookcase2BookCaseRspBody(bookcase);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookCase(
			BookCaseReqBody bookCaseReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		CoredataBookcase bookcase = BookCaseConverter.bookCaseReqBody2CoredataBookcase(bookCaseReqBody);
		bookcase.setCreator("XXX");
		bookcase.setOrgId("XXX");
		bookcase.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcase = coredataBookCaseRepository.save(bookcase);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookcase.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookCase(String bookcaseId,
			BookCaseReqBody bookCaseReqBody) {
		GeneralResult result = new GeneralResult();
		CoredataBookcase tmp = coredataBookCaseRepository.findBookCaseById(bookcaseId);
		if(tmp==null){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		CoredataBookcase bookcase = BookCaseConverter
				.bookCaseReqBody2CoredataBookcase(bookCaseReqBody);
		bookcase.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcase.setCreator("XXX");
		bookcase.setOrgId("XXX");
		bookcase.setId(bookcaseId);
		bookcase = coredataBookCaseRepository
				.save(bookcase);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCases(String bookcaseId) {
		GeneralResult result = new GeneralResult();
		int tmp = coredataBookCaseRepository.setStatusFor(BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED, bookcaseId);
		if(1==tmp){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		}else {
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

	@Override
	public GeneralContentResult<List<BookCaseRspBody>> findBookCaseByName(String name) {
		GeneralContentResult<List<BookCaseRspBody>> result = new GeneralContentResult<List<BookCaseRspBody>>();
		List<BookCaseRspBody> bodies = new ArrayList<BookCaseRspBody>();
		List<CoredataBookcase> bookauthors = coredataBookCaseRepository
				.findBookCaseByName(name);
		for (CoredataBookcase bookcase : bookauthors) {
			bodies.add(BookCaseConverter.coredataBookcase2BookCaseRspBody(bookcase));
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(bodies);
		return result;
	}

}
