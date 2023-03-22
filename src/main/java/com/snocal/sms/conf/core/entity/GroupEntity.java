package com.snocal.sms.conf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.snocal.sms.module.commom.entity.SNEntity;

@Entity
@Table(name = "SN_GROUP")
public class GroupEntity extends SNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="group_name")
	private String groupName;

	@OneToMany(mappedBy = "groupEntity")
	private Set<MenuEntity> menuEntitySet = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
