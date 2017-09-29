package com.jin.security.auth.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "groups")
public class Groups implements Serializable{

	private static final long serialVersionUID = -8481053891328891348L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "group_name", nullable = false)
	private String groupName;

	@ManyToMany
	@JoinTable(
      name="users_groups",
      joinColumns=@JoinColumn(name="group_id", referencedColumnName="id", foreignKey = @ForeignKey(name = "FK_GROUPS")),
      inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
	private List<Users> users;

	@OneToMany(mappedBy="group")
	private List<GroupDomainAcl> groupDomainAcls;


}
