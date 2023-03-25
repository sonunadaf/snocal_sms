package com.snocal.sms.conf.core.dto;

import java.util.List;

import com.snocal.sms.module.commom.dto.SNAbstractDTO;

public class GroupDTO extends SNAbstractDTO<Long> {

	private String groupName;

	private List<MenuDTO> menuList;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<MenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}

}
