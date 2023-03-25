package com.snocal.sms.conf.core.dto;

import com.snocal.sms.module.commom.dto.SNAbstractDTO;

public class MenuDTO extends SNAbstractDTO<Long> {

	private String menuName;
	private GroupDTO groupDTO;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public GroupDTO getGroupDTO() {
		return groupDTO;
	}

	public void setGroupDTO(GroupDTO groupDTO) {
		this.groupDTO = groupDTO;
	}

}
