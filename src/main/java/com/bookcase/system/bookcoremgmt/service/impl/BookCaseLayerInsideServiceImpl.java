/**
 * Project Name:book-coredatemgmt
 * File Name:BookTypelaer.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:11:47
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
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcaseLayerinside;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcaselayerinside.BookCaseLayerInsideReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookcoremgmt.otd.bookcaselayerinside.BookCaseLayerInsideRspBody;
import com.bookcase.system.bookcoremgmt.repository.CoredataBookcaseLayerinsideRepository;
import com.bookcase.system.bookcoremgmt.service.BookCaseLayerInsideService;
import com.bookcase.system.bookcoremgmt.utils.BookcaseConverter;
import com.bookcase.system.bookcoremgmt.utils.BookcaseLayerinsideConverter;

/**
 * ClassName:BookTypelaer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:11:47 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCaseLayerInsideServiceImpl implements BookCaseLayerInsideService{

	@Autowired
	CoredataBookcaseLayerinsideRepository coredataBookcaseLayerinsideRepository;
	
	@Override
	public GeneralPagingResult<List<BookCaseLayerInsideRspBody>> findBookCaseLayerInsides(
			String page, String size) {
		GeneralPagingResult<List<BookCaseLayerInsideRspBody>> result = new GeneralPagingResult<List<BookCaseLayerInsideRspBody>>();
		List<BookCaseLayerInsideRspBody> rspBodies = new ArrayList<BookCaseLayerInsideRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<CoredataBookcaseLayerinside> pg = coredataBookcaseLayerinsideRepository
				.findCoredataBookcaseLayerInsides(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (CoredataBookcaseLayerinside layerinside : pg.getContent()) {
				rspBodies.add(BookcaseLayerinsideConverter
								.CoredataBookcaseLayerinside2BookCaseLayerInsideRspBody(layerinside));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCaseLayerInsideRspBody> findBookCaseLayerInsideById(
			String bookCaseLayerInsideId) {
		GeneralContentResult<BookCaseLayerInsideRspBody> result = new GeneralContentResult<BookCaseLayerInsideRspBody>();
		CoredataBookcaseLayerinside layerinside  = coredataBookcaseLayerinsideRepository.findOne(bookCaseLayerInsideId);
		BookCaseLayerInsideRspBody rspBody = BookcaseLayerinsideConverter.CoredataBookcaseLayerinside2BookCaseLayerInsideRspBody(layerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookCaseLayerInside(
			BookCaseLayerInsideReqBody layerInsideReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		CoredataBookcaseLayerinside layerinside = BookcaseLayerinsideConverter.bookCaseLayerInsideReqBody2CoredataBookcaseLayerinside(layerInsideReqBody);
		layerinside.setCreator("XXX");
		layerinside.setOrgId("XXX");
		layerinside.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		layerinside = coredataBookcaseLayerinsideRepository.save(layerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(layerinside.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookCaseLayerInside(String bookCaseLayerInsideId,
			BookCaseLayerInsideReqBody layerInsideReqBody) {
		GeneralResult result = new GeneralResult();
		CoredataBookcaseLayerinside tmp = coredataBookcaseLayerinsideRepository.findCoredataBookcaseLayerInsideById(bookCaseLayerInsideId);
		if(tmp==null){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		CoredataBookcaseLayerinside layerinside = BookcaseLayerinsideConverter
				.bookCaseLayerInsideReqBody2CoredataBookcaseLayerinside(layerInsideReqBody);
		layerinside.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		layerinside.setCreator("XXX");
		layerinside.setOrgId("XXX");
		layerinside.setId(bookCaseLayerInsideId);
		layerinside = coredataBookcaseLayerinsideRepository
				.save(layerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCaseLayerInsides(
			BookCaseLayerInsideReqParam bookCaseLayerInsideReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookCaseLayerInsideReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookCaseLayerInsideReqParam.getIds()){
			int tmp = coredataBookcaseLayerinsideRepository.setStatusFor(BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

