package com.bookcase.system.bookcoremgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqBody;
import com.bookcase.system.bookcoremgmt.dto.bookcase.BookCaseReqParam;
import com.bookcase.system.bookcoremgmt.otd.bookcase.BookCaseRspBody;

public interface BookCaseService {

	GeneralPagingResult<List<BookCaseRspBody>> findBookCases(String page,
			String size);

	GeneralContentResult<BookCaseRspBody> findBookCaseById(String bookcaseId);

	GeneralContentResult<String> createBookCase(BookCaseReqBody bookCaseReqBody);

	GeneralResult updateBookCase(String bookcaseId,
			BookCaseReqBody bookCaseReqBody);

	GeneralResult deleteBookCases(BookCaseReqParam bookCaseReqParam);

}
