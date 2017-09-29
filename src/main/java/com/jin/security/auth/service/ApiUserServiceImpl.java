package com.jin.security.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.security.auth.domain.ApiUsers;
import com.jin.security.auth.repository.ApiUsersRepository;

@Service
public class ApiUserServiceImpl implements ApiUserService {

	@Autowired
	ApiUsersRepository apiUsersRepository;
/*	
	@Autowired
	ApiRolesRepository apiRolesRepository;
	
	@PostConstruct
	public void init() {
		
		ApiRoles apiRoles = new ApiRoles();
		apiRoles.setRoleName("AuthAdmin");
		apiRolesRepository.save(apiRoles);
		List<ApiRoles> apiRolesList = new ArrayList<ApiRoles>();
		apiRolesList.add(apiRoles);
		
		ApiUsers apiUsers = new ApiUsers();
		apiUsers.setUsername("authuser");
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		apiUsers.setPassword(encoder.encode("authpass"));
		apiUsers.setFirstName("Jin");
		apiUsers.setLastName("Zuo");
		apiUsers.setApiRoles(apiRolesList);
		apiUsers.setEnabled(true);
		apiUsers.setUserSource("internal");
		apiUsersRepository.save(apiUsers);
		
		
	}
*/	
	@Override
	public ApiUsers getApiUserByUsername(String username) {
		ApiUsers apiUser = apiUsersRepository.findByUsername(username);
				
		return apiUser;
	}

}
