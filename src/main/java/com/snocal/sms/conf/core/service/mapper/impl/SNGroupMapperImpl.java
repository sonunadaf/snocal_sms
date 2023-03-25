package com.snocal.sms.conf.core.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.snocal.sms.conf.core.dto.GroupDTO;
import com.snocal.sms.conf.core.dto.MenuDTO;
import com.snocal.sms.conf.core.entity.GroupEntity;
import com.snocal.sms.conf.core.service.mapper.inf.GroupMapper;
import com.snocal.sms.conf.core.service.mapper.inf.MenuMapper;

@Component("snGroupMapperImpl")
public class SNGroupMapperImpl implements GroupMapper {

	@Autowired
	private ReferenceMapper referenceMapper;

	@Autowired
	@Qualifier("snMenuMapperImpl")
	private MenuMapper menuMapper;

	@Override
	public GroupDTO asDTO(GroupEntity entity) {
		if (entity == null) {
			return null;
		}
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setId(entity.getId());
		groupDTO.setGroupName(entity.getGroupName());
		if (entity.getMenuEntitySet() != null && !entity.getMenuEntitySet().isEmpty()) {
			List<MenuDTO> menuList = menuMapper.asDTOList(List.copyOf(entity.getMenuEntitySet()));
			groupDTO.setMenuList(menuList);
		}
		return groupDTO;
	}

	@Override
	public List<GroupEntity> asEntityList(List<GroupDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<GroupEntity> list = new ArrayList<GroupEntity>(dtoList.size());
		for (GroupDTO groupDTO : dtoList) {
			list.add(asEntity(groupDTO));
		}

		return list;
	}

	@Override
	public List<GroupDTO> asDTOList(List<GroupEntity> entityList) {
		if (entityList == null) {
			return null;
		}
		List<GroupDTO> list = new ArrayList<GroupDTO>(entityList.size());
		for (GroupEntity groupEntity : entityList) {
			list.add(asDTO(groupEntity));
		}

		return list;
	}

	@Override
	public GroupEntity asEntity(GroupDTO dto) {
		if (dto == null) {
			return null;
		}
		GroupEntity groupEntity = referenceMapper.resolve(dto, GroupEntity.class);
		groupEntity.setId(dto.getId());
		groupEntity.setGroupName(dto.getGroupName());
		if (dto.getMenuList() != null && !dto.getMenuList().isEmpty()) {
			groupEntity.setMenuEntitySet(Set.copyOf(menuMapper.asEntityList(dto.getMenuList())));
		}
		return groupEntity;
	}
}
