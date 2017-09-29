package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.ApiUsers;

public interface ApiUsersRepository extends PagingAndSortingRepository<ApiUsers, Long> {

	public ApiUsers findByUsername(String username);
}
