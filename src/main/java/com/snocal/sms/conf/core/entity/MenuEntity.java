package com.snocal.sms.conf.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "sn_menu")
public class MenuEntity extends SNEntity {

	@OneToOne(mappedBy = "menuEntity")
	private AppApisEntity appApisEntity;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupEntity groupEntity;

	@Column(name = "menu_name")
	private String menuName;

	public AppApisEntity getAppApisEntity() {
		return appApisEntity;
	}

	public void setAppApisEntity(AppApisEntity appApisEntity) {
		this.appApisEntity = appApisEntity;
	}

	public GroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(GroupEntity groupEntity) {
		this.groupEntity = groupEntity;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
