/**
 * Project Name:book-coremgmt
 * File Name:CoredataBookDispatchRepository.java
 * Package Name:com.bookcase.system.bookcoremgmt.repository
 * Date:2017年6月4日下午3:40:53
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcomment;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookdispatch;

/**
 * ClassName:CoredataBookDispatchRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午3:40:53 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface CoredataBookDispatchRepository extends JpaRepository<CoredataBookdispatch, String>{

	@Query("SELECT a FROM CoredataBookdispatch a where a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<CoredataBookdispatch> findBookDispatchs(PageRequest request);

	@Query("SELECT a FROM CoredataBookdispatch a where a.id = ?1 AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	CoredataBookdispatch findBookDispatchById(String bookDispatchId);

	@Query("UPDATE CoredataBookdispatch a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

