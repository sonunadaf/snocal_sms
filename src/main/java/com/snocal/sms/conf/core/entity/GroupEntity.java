package com.snocal.sms.conf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "SN_GROUP")
public class GroupEntity extends SNEntity {

	@Column(name = "group_name")
	private String groupName;

	@OneToMany(mappedBy = "groupEntity")
	private Set<MenuEntity> menuEntitySet = new HashSet<>();

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<MenuEntity> getMenuEntitySet() {
		return menuEntitySet;
	}

	public void setMenuEntitySet(Set<MenuEntity> menuEntitySet) {
		this.menuEntitySet = menuEntitySet;
	}

}
