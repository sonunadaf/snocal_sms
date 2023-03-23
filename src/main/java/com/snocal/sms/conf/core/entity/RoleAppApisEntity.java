package com.snocal.sms.conf.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "role_app_apis")
public class RoleAppApisEntity extends SNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;

	@ManyToOne
	@JoinColumn(name = "app_api_id")
	private AppApisEntity appApisEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
