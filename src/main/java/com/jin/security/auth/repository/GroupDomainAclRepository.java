package com.jin.security.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jin.security.auth.domain.GroupDomainAcl;

public interface GroupDomainAclRepository extends PagingAndSortingRepository<GroupDomainAcl, Long> {

}
