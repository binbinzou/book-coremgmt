/**
 * Project Name:book-coredatemgmt
 * File Name:BookCommentServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:05:41
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
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcomment;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcomment.BookCommentReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;
import com.bookcase.system.bookcoremgmt.otd.bookcomment.BookCommentRspBody;
import com.bookcase.system.bookcoremgmt.repository.CoredataBookCommentRepository;
import com.bookcase.system.bookcoremgmt.service.BookCommentService;
import com.bookcase.system.bookcoremgmt.utils.BookCaseConverter;
import com.bookcase.system.bookcoremgmt.utils.BookCommentConverter;

/**
 * ClassName:BookCommentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:05:41 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCommentServiceImpl implements BookCommentService {

	@Autowired
	CoredataBookCommentRepository coredataBookCommentRepository;
	
	@Override
	public GeneralPagingResult<List<BookCommentRspBody>> findBookComments(
			String page, String size) {
		GeneralPagingResult<List<BookCommentRspBody>> result = new GeneralPagingResult<List<BookCommentRspBody>>();
		List<BookCommentRspBody> rspBodies = new ArrayList<BookCommentRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<CoredataBookcomment> pg = coredataBookCommentRepository
				.findBookComments(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (CoredataBookcomment coredataBookcomment : pg.getContent()) {
				rspBodies.add(BookCommentConverter
								.coredataBookcomment2BookCommentRspBody(coredataBookcomment));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCommentRspBody> findBookCommentById(
			String bookCommentId) {
		GeneralContentResult<BookCommentRspBody> result = new GeneralContentResult<BookCommentRspBody>();
		CoredataBookcomment bookcomment  = coredataBookCommentRepository.findOne(bookCommentId);
		BookCommentRspBody rspBody = BookCommentConverter.coredataBookcomment2BookCommentRspBody(bookcomment);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookComment(
			BookCommentReqBody bookCommentReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		CoredataBookcomment bookcomment = BookCommentConverter.bookCommentReqBody2CoredataBookcomment(bookCommentReqBody);
		bookcomment.setCreator("XXX");
		bookcomment.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcomment = coredataBookCommentRepository.save(bookcomment);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookcomment.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookComment(String bookCommentId,
			BookCommentReqBody bookCommentReqBody) {
		GeneralResult result = new GeneralResult();
		CoredataBookcomment tmp = coredataBookCommentRepository.findBookCommentById(bookCommentId);
		if(tmp==null){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		CoredataBookcomment bookcomment = BookCommentConverter
				.bookCommentReqBody2CoredataBookcomment(bookCommentReqBody);
		bookcomment.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcomment.setCreator("XXX");
		bookcomment.setId(bookCommentId);
		bookcomment = coredataBookCommentRepository
				.save(bookcomment);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookComments(
			BookCommentReqParam bookCommentReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookCommentReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookCommentReqParam.getIds()){
			int tmp = coredataBookCommentRepository.setStatusFor(BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

