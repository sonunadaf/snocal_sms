package com.snocal.sms.conf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "SN_APIS")
public class AppApisEntity extends SNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String urls;

	@Column(name = "method_type")
	private String methodType;

	private String params;

	@OneToMany(mappedBy = "appApisEntity")
	private Set<RoleAppApisEntity> roleAppApisEntitySet = new HashSet<>();

	@OneToOne(mappedBy = "appApisEntity")
	@JoinColumn(name = "menu_id")
	private MenuEntity menuEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Set<RoleAppApisEntity> getRoleAppApisEntitySet() {
		return roleAppApisEntitySet;
	}

	public void setRoleAppApisEntitySet(Set<RoleAppApisEntity> roleAppApisEntitySet) {
		this.roleAppApisEntitySet = roleAppApisEntitySet;
	}

	public MenuEntity getMenuEntity() {
		return menuEntity;
	}

	public void setMenuEntity(MenuEntity menuEntity) {
		this.menuEntity = menuEntity;
	}

	

}
