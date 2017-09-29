package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.DomainResources;

public interface DomainResourcesRepository extends PagingAndSortingRepository<DomainResources, Long> {

}
