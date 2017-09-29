package com.jin.security.auth.service;

import com.jin.security.auth.entity.UserDomainAcl;

public interface UserDomainAclService {

	public UserDomainAcl getUserDomainAcl(String userName, String domainClass);
}
