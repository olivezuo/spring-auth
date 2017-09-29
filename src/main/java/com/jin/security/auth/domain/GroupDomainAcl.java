package com.jin.security.auth.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "group_domain_acl")
public class GroupDomainAcl {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(targetEntity = DomainResources.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "domain_resource_id",foreignKey = @ForeignKey(name = "FK_DOMAIN_RESOURCES"))
	private DomainResources domainResource;
	
	
	@ManyToOne(targetEntity = Groups.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "group_id",foreignKey = @ForeignKey(name = "FK_ACL_GROUPS"))
	private Groups group;

	@Column(name = "allow_read", nullable = false)
	private boolean allowRead = false;
	
	@Column(name = "allow_create", nullable = false)
	private boolean allowCreate = false;

	@Column(name = "allow_update", nullable = false)
	private boolean allowUpdate = false;
	
	@Column(name = "allow_delete", nullable = false)
	private boolean allowDelete = false;

	@Column(name = "active", nullable = false)
	private boolean active = true;

}
