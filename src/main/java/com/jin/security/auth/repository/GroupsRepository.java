package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.Groups;

public interface GroupsRepository extends PagingAndSortingRepository<Groups, Long> {

}
