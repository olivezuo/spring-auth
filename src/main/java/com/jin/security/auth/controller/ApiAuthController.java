package com.jin.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jin.security.auth.domain.ApiUsers;
import com.jin.security.auth.service.ApiUserService;

@RestController
public class ApiAuthController {

	@Autowired
	ApiUserService apiUserService;

	@PreAuthorize("hasAuthority('AuthAdmin')")
	@RequestMapping(value = "/apiauth", method = RequestMethod.POST)
	public ApiUsers auth(@RequestParam("username") String username) {
		ApiUsers apiUser = apiUserService.getApiUserByUsername(username);

		return apiUser;
	}

}
