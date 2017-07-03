/**
 * Project Name:book-coremgmt
 * File Name:BookCaseRepository.java
 * Package Name:com.bookcase.system.bookcoremgmt.repository
 * Date:2017年6月3日下午3:47:23
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookcoremgmt.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookcase.system.bookcoremgmt.constant.BookCoredataMgmtConstant;
import com.bookcase.system.bookcoremgmt.domain.CoredataBookcase;

/**
 * ClassName:BookCaseRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午3:47:23 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface CoredataBookCaseRepository extends JpaRepository<CoredataBookcase, String>{

	@Query("SELECT a FROM CoredataBookcase a where a.name like CONCAT('%',:name,'%') AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<CoredataBookcase> findBookCases(@Param("name") String name, Pageable pageable);

	@Query("SELECT a FROM CoredataBookcase a where a.id = ?1 AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	CoredataBookcase findBookCaseById(String bookcaseId);

	@Modifying
	@Query("UPDATE CoredataBookcase a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

	@Query("SELECT a FROM CoredataBookcase a where a.name like CONCAT('%',:name,'%') AND a.status<" + BookCoredataMgmtConstant.STATUS_GLOBAL_DELETED)
	List<CoredataBookcase> findBookCaseByName(@Param("name") String name);

	
	
}

