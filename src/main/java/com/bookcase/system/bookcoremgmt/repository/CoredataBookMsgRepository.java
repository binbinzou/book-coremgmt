/**
 * Project Name:book-coremgmt
 * File Name:CoredataBookMsgRepository.java
 * Package Name:com.bookcase.system.bookcoremgmt.repository
 * Date:2017年6月4日下午4:07:11
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookmsg;

/**
 * ClassName:CoredataBookMsgRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午4:07:11 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface CoredataBookMsgRepository extends JpaRepository<CoredataBookmsg, String>{

	@Query("SELECT a FROM CoredataBookmsg a where a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<CoredataBookmsg> findBookMsgs( Pageable pageable);

	@Query("SELECT a FROM CoredataBookmsg a where a.id = ?1 AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	CoredataBookmsg findBookMsgById(String bookmsgId);

	@Modifying
	@Query("UPDATE CoredataBookmsg a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

