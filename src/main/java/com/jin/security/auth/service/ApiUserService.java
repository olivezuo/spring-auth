package com.jin.security.auth.service;

import com.jin.security.auth.domain.ApiUsers;

public interface ApiUserService {

	public ApiUsers getApiUserByUsername(String username) ;
	
}
