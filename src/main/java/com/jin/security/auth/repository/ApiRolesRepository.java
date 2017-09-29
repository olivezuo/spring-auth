package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.ApiRoles;

public interface ApiRolesRepository extends PagingAndSortingRepository<ApiRoles, Long> {


}
