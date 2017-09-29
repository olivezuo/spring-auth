package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {

}
