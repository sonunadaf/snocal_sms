package com.snocal.sms.conf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.PrimaryKeyEntity;
import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "SN_ROLE")
public class RoleEntity extends SNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String role;

	@OneToMany(mappedBy = "roleEntity")
	private Set<UserRoleEntity> userRoleEntitySet = new HashSet<>();

	@OneToMany(mappedBy = "roleEntity")
	private Set<RoleAppApisEntity> roleAppApisEntitySet = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserRoleEntity> getUserRoleEntitySet() {
		return userRoleEntitySet;
	}

	public void setUserRoleEntitySet(Set<UserRoleEntity> userRoleEntitySet) {
		this.userRoleEntitySet = userRoleEntitySet;
	}

	public Set<RoleAppApisEntity> getRoleAppApisEntitySet() {
		return roleAppApisEntitySet;
	}

	public void setRoleAppApisEntitySet(Set<RoleAppApisEntity> roleAppApisEntitySet) {
		this.roleAppApisEntitySet = roleAppApisEntitySet;
	}

}
