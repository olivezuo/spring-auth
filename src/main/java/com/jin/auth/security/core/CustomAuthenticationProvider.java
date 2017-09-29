package com.jin.auth.security.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jin.security.auth.domain.ApiRoles;
import com.jin.security.auth.domain.ApiUsers;
import com.jin.security.auth.service.ApiUserService;

@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private ApiUserService apiUserService;
	

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1) throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		String password = (String) authentication.getCredentials();
		if (!StringUtils.hasText(password)) {
			logger.warn("Username {}: no password provided", username);
		    throw new BadCredentialsException("Please enter password");
		}
		
		ApiUsers apiUsers = apiUserService.getApiUserByUsername(username);
		if (apiUsers == null) {
        	logger.warn("Username {} password {}: user not found", username, password);
            throw new UsernameNotFoundException("Invalid Login");
        }
				
		if (!passwordEncoder().matches(password, apiUsers.getPassword())) {
        	logger.warn("Username {} password {}: invalid password", username, password);
            throw new BadCredentialsException("Invalid Login");
        }
		        
        if (!apiUsers.isEnabled()) {
        	logger.warn("Username {}: disabled", username);
            throw new BadCredentialsException("User disabled");
        }
				
		List<ApiRoles> apiRoles = apiUsers.getApiRoles();
		List<String> roles = new ArrayList<String>();
		
		for (ApiRoles apiRole : apiRoles) {
			roles.add(apiRole.getRoleName());
		}
		
		List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roles.toArray(new String[0]));
			
		//auths = AuthorityUtils.NO_AUTHORITIES;
		return new User(username, password, 
				true, // enabled
                true, // account not expired
                true, // credentials not expired
                true, // account not locked
                auths);

	}

}
