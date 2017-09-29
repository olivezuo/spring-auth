package com.jin.security.auth.entity;

import java.io.Serializable;

public class UserDomainAcl implements Serializable {

	private static final long serialVersionUID = 3540247337603232052L;

	private String userName;
	
	private String domainName;
	
	private String domainClass;
	
	private boolean allowRead;
	
	private boolean allowCreate;
	
	private boolean allowUpdate;
	
	private boolean allowDelete;
	
	public UserDomainAcl(){
		
	}

	public UserDomainAcl(String userName, String domainName, String domainClass, boolean allowRead,
			boolean allowCreate, boolean allowUpdate, boolean allowDelete) {
		super();
		this.userName = userName;
		this.domainName = domainName;
		this.domainClass = domainClass;
		this.allowRead = allowRead;
		this.allowCreate = allowCreate;
		this.allowUpdate = allowUpdate;
		this.allowDelete = allowDelete;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainClass() {
		return domainClass;
	}

	public void setDomainClass(String domainClass) {
		this.domainClass = domainClass;
	}

	public boolean isAllowRead() {
		return allowRead;
	}

	public void setAllowRead(boolean allowRead) {
		this.allowRead = allowRead;
	}

	public boolean isAllowCreate() {
		return allowCreate;
	}

	public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public boolean isAllowUpdate() {
		return allowUpdate;
	}

	public void setAllowUpdate(boolean allowUpdate) {
		this.allowUpdate = allowUpdate;
	}

	public boolean isAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}


	
	
	
	
}
