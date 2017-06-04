/**
 * Project Name:book-coremgmt
 * File Name:CoredataBookCommentRepository.java
 * Package Name:com.bookcase.system.bookcoremgmt.repository
 * Date:2017年6月4日下午3:11:20
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

/**
 * ClassName:CoredataBookCommentRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月4日 下午3:11:20 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface CoredataBookCommentRepository extends JpaRepository<CoredataBookcomment, String>{

	@Query("SELECT a FROM CoredataBookcomment a where a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<CoredataBookcomment> findBookComments(PageRequest request);

	@Query("SELECT a FROM CoredataBookcomment a where a.id = ?1 AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	CoredataBookcomment findBookCommentById(String bookCommentId);

	@Query("UPDATE CoredataBookcomment a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

