/**
 * Project Name:book-coremgmt
 * File Name:CoredataBookcaseLayerinsideRepository.java
 * Package Name:com.bookcase.system.bookcoremgmt.repository
 * Date:2017年6月3日下午6:01:31
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcaseLayerinside;


/**
 * ClassName:CoredataBookcaseLayerinsideRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午6:01:31 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface CoredataBookcaseLayerinsideRepository extends JpaRepository<CoredataBookcaseLayerinside, String>{

	@Query("SELECT a FROM CoredataBookcaseLayerinside a where a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<CoredataBookcaseLayerinside> findCoredataBookcaseLayerInsides(
			Pageable pageable);

	@Query("SELECT a FROM CoredataBookcaseLayerinside a where a.id = ?1 AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	CoredataBookcaseLayerinside findCoredataBookcaseLayerInsideById(
			String bookCaseLayerInsideId);

	@Query("UPDATE CoredataBookcaseLayerinside a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}

