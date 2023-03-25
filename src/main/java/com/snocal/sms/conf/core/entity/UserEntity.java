package com.snocal.sms.conf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "SN_USER")
public class UserEntity extends SNEntity {

	@Column(name = "user_name")
	private String userName;

	private String password;

	@OneToMany(mappedBy = "userEntity")
	private Set<UserRoleEntity> userRoleEntitySet = new HashSet<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRoleEntity> getUserRoleEntitySet() {
		return userRoleEntitySet;
	}

	public void setUserRoleEntitySet(Set<UserRoleEntity> userRoleEntitySet) {
		this.userRoleEntitySet = userRoleEntitySet;
	}

}
