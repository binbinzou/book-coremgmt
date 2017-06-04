/**
 * Project Name:book-coredatemgmt
 * File Name:BookMsgServiceImpl.java
 * Package Name:com.bookcase.system.bookcoredatamgmt.service.impl
 * Date:2017年5月23日上午8:09:58
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
import com.bookcase.system.bookcoremgmt.domain.CoredataBookdispatch;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookmsg;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookmsg.BookMsgReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookmsg.BookMsgRspBody;
import com.bookcase.system.bookcoremgmt.repository.CoredataBookMsgRepository;
import com.bookcase.system.bookcoremgmt.service.BookMsgService;
import com.bookcase.system.bookcoremgmt.utils.BookDispatchConverter;
import com.bookcase.system.bookcoremgmt.utils.BookMsgConverter;

/**
 * ClassName:BookMsgServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月23日 上午8:09:58 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookMsgServiceImpl implements BookMsgService {

	@Autowired
	CoredataBookMsgRepository coredataBookMsgRepository;
	
	@Override
	public GeneralPagingResult<List<BookMsgRspBody>> findBookMsgs(String page,
			String size) {
		GeneralPagingResult<List<BookMsgRspBody>> result = new GeneralPagingResult<List<BookMsgRspBody>>();
		List<BookMsgRspBody> rspBodies = new ArrayList<BookMsgRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<CoredataBookmsg> pg = coredataBookMsgRepository
				.findBookMsgs(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (CoredataBookmsg coredataBookmsg : pg.getContent()) {
				rspBodies.add(BookMsgConverter
								.coredataBookmsg2BookMsgRspBody(coredataBookmsg));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookMsgRspBody> findBookMsgById(String bookmsgId) {
		GeneralContentResult<BookMsgRspBody> result = new GeneralContentResult<BookMsgRspBody>();
		CoredataBookmsg bookmsg  = coredataBookMsgRepository.findOne(bookmsgId);
		BookMsgRspBody rspBody = BookMsgConverter.coredataBookmsg2BookMsgRspBody(bookmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookMsg(
			BookMsgReqBody bookMsgReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		CoredataBookmsg bookmsg = BookMsgConverter.bookMsgReqBody2CoredataBookmsg(bookMsgReqBody);
		bookmsg.setCreator("XXX");
		bookmsg.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookmsg = coredataBookMsgRepository.save(bookmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookmsg.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookMsg(String bookmsgId,
			BookMsgReqBody bookMsgReqBody) {
		GeneralResult result = new GeneralResult();
		CoredataBookmsg tmp = coredataBookMsgRepository.findBookMsgById(bookmsgId);
		if(tmp==null){
			result.setCode(BookCoredataMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		CoredataBookmsg bookmsg = BookMsgConverter
				.bookMsgReqBody2CoredataBookmsg(bookMsgReqBody);
		bookmsg.setStatus(BookCoredataMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookmsg.setCreator("XXX");
		bookmsg.setId(bookmsgId);
		bookmsg = coredataBookMsgRepository
				.save(bookmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookMsgs(BookMsgReqParam bookMsgReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookMsgReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookMsgReqParam.getIds()){
			int tmp = coredataBookMsgRepository.setStatusFor(BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

