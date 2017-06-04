/**
 * Project Name:book-coredatemgmt
 * File Name:BookDispatchServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:07:43
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

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
import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtResultConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookdispatch;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookdispatch.BookDispatchReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookcoremgmt.otd.bookdispatch.BookDispatchRspBody;
import com.bookcase.system.bookcoremgmt.repository.CoredataBookDispatchRepository;
import com.bookcase.system.bookcoremgmt.service.BookDispatchService;
import com.bookcase.system.bookcoremgmt.utils.BookDispatchConverter;
import com.bookcase.system.bookcoremgmt.utils.BookcaseConverter;

/**
 * ClassName:BookDispatchServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:07:43 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookDispatchServiceImpl implements BookDispatchService {

	@Autowired
	CoredataBookDispatchRepository coredataBookDispatchRepository;
	
	@Override
	public GeneralPagingResult<List<BookDispatchRspBody>> findBookDispatchs(
			String page, String size) {
		GeneralPagingResult<List<BookDispatchRspBody>> result = new GeneralPagingResult<List<BookDispatchRspBody>>();
		List<BookDispatchRspBody> rspBodies = new ArrayList<BookDispatchRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<CoredataBookdispatch> pg = coredataBookDispatchRepository
				.findBookDispatchs(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (CoredataBookdispatch coredataBookdispatch : pg.getContent()) {
				rspBodies.add(BookDispatchConverter
								.coredataBookdispatch2BookDispatchRspBody(coredataBookdispatch));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookDispatchRspBody> findBookDispatchById(
			String bookDispatchId) {
		GeneralContentResult<BookDispatchRspBody> result = new GeneralContentResult<BookDispatchRspBody>();
		CoredataBookdispatch bookdispatch  = coredataBookDispatchRepository.findOne(bookDispatchId);
		BookDispatchRspBody rspBody = BookDispatchConverter.coredataBookdispatch2BookDispatchRspBody(bookdispatch);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookDispatch(
			BookDispatchReqBody bookDispatchReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		CoredataBookdispatch bookdispatch = BookDispatchConverter.bookDispatchReqBody2CoredataBookdispatch(bookDispatchReqBody);
		bookdispatch.setCreator("XXX");
		bookdispatch.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookdispatch = coredataBookDispatchRepository.save(bookdispatch);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookdispatch.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookDispatch(String bookDispatchId,
			BookDispatchReqBody bookDispatchReqBody) {
		GeneralResult result = new GeneralResult();
		CoredataBookdispatch tmp = coredataBookDispatchRepository.findBookDispatchById(bookDispatchId);
		if(tmp==null){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		CoredataBookdispatch bookdispatch = BookDispatchConverter
				.bookDispatchReqBody2CoredataBookdispatch(bookDispatchReqBody);
		bookdispatch.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookdispatch.setCreator("XXX");
		bookdispatch.setId(bookDispatchId);
		bookdispatch = coredataBookDispatchRepository
				.save(bookdispatch);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookDispatchs(
			BookDispatchReqParam bookDispatchReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookDispatchReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookDispatchReqParam.getIds()){
			int tmp = coredataBookDispatchRepository.setStatusFor(BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED, id);
			if(tmp>0){
				tmpSize++;
			}
		}
		if(size==tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		}else if(size>tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("部分数据删除成功");
		}else if(tmpSize==0){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

}

