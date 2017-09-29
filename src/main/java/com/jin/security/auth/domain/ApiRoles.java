package com.jin.security.auth.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "api_roles")
public class ApiRoles implements Serializable{

	private static final long serialVersionUID = -3892833772298574045L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "role_name", nullable = false)
	private String roleName;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
      name="api_users_roles",
      joinColumns=@JoinColumn(name="role_id", referencedColumnName="id", foreignKey = @ForeignKey(name = "FK_API_ROLES")),
      inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
	private List<ApiUsers> apiUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<ApiUsers> getApiUsers() {
		return apiUsers;
	}

	public void setApiUsers(List<ApiUsers> apiUsers) {
		this.apiUsers = apiUsers;
	}
	
}
