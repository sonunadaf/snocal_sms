package com.snocal.sms.conf.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "role_app_apis")
public class RoleAppApisEntity extends SNEntity {

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;

	@ManyToOne
	@JoinColumn(name = "app_api_id")
	private AppApisEntity appApisEntity;

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public AppApisEntity getAppApisEntity() {
		return appApisEntity;
	}

	public void setAppApisEntity(AppApisEntity appApisEntity) {
		this.appApisEntity = appApisEntity;
	}

}
