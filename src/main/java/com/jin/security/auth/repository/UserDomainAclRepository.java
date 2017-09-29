package com.jin.security.auth.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.jin.data.datasource.TargetDataSource;
import com.jin.security.auth.entity.UserDomainAcl;

@Component
public class UserDomainAclRepository  {
	
	@PersistenceContext
    private EntityManager em;

	@TargetDataSource(value="master")
	public List<UserDomainAcl> getUserDomainAcl(String userName, String domainClass){
		List<UserDomainAcl> uoas = em.createNamedQuery("UserAcl.findByUserIdAndDomainClassName").setParameter("userName", userName).setParameter("domainClass", domainClass).getResultList();
		return uoas;
	}


}
