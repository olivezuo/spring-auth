package com.jin.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jin.security.auth.entity.UserDomainAcl;
import com.jin.security.auth.service.UserDomainAclService;

@RestController
public class AuthController {

	@Autowired
	UserDomainAclService userDomainAclService;
	
    @PreAuthorize("hasAuthority('AuthAdmin')")
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public UserDomainAcl auth(@RequestParam("userName") String userName, @RequestParam("domainClass") String domainClass){
		UserDomainAcl userDomainAcl = userDomainAclService.getUserDomainAcl(userName, domainClass);
		
		return userDomainAcl;
	}

}
