package com.jin.security.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jin.security.auth.entity.UserDomainAcl;
import com.jin.security.auth.repository.UserDomainAclRepository;

@Service
public class UserDomainAclServiceImpl implements UserDomainAclService {
	@Autowired
	UserDomainAclRepository userDomainAclRepository;
	
	@Cacheable(cacheNames="authacl")
	public UserDomainAcl getUserDomainAcl(String userName, String domainClass){
		List<UserDomainAcl> userAcls = userDomainAclRepository.getUserDomainAcl(userName, domainClass);
		
		UserDomainAcl userDomainAcl = new UserDomainAcl();
		userDomainAcl.setUserName(userName);
		userDomainAcl.setDomainClass(domainClass);
		
		
		for (UserDomainAcl userAcl: userAcls) {
			userDomainAcl.setAllowCreate(userAcl.isAllowCreate() || userDomainAcl.isAllowCreate());
			userDomainAcl.setAllowRead(userAcl.isAllowRead() || userDomainAcl.isAllowRead());
			userDomainAcl.setAllowUpdate(userAcl.isAllowUpdate() || userDomainAcl.isAllowUpdate());
			userDomainAcl.setAllowDelete(userAcl.isAllowDelete() || userDomainAcl.isAllowDelete());
		}
		
		return userDomainAcl;
	}

}
