package com.snocal.sms.conf.core.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.snocal.sms.conf.core.dto.MenuDTO;
import com.snocal.sms.conf.core.entity.MenuEntity;
import com.snocal.sms.conf.core.service.mapper.inf.GroupMapper;
import com.snocal.sms.conf.core.service.mapper.inf.MenuMapper;

@Component("snMenuMapperImpl")
public class SNMenuMapperImpl implements MenuMapper {

	@Autowired
	private ReferenceMapper referenceMapper;

	@Override
	public MenuDTO asDTO(MenuEntity entity) {
		if (entity == null) {
			return null;
		}
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setId(entity.getId());
		menuDTO.setMenuName(entity.getMenuName());
		return menuDTO;
	}

	@Override
	public List<MenuEntity> asEntityList(List<MenuDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<MenuEntity> list = new ArrayList<MenuEntity>(dtoList.size());
		for (MenuDTO menuDTO : dtoList) {
			list.add(asEntity(menuDTO));
		}

		return list;
	}

	@Override
	public List<MenuDTO> asDTOList(List<MenuEntity> entityList) {
		if (entityList == null) {
			return null;
		}
		List<MenuDTO> list = new ArrayList<MenuDTO>(entityList.size());
		for (MenuEntity menuEntity : entityList) {
			list.add(asDTO(menuEntity));
		}
		return list;
	}

	@Override
	public MenuEntity asEntity(MenuDTO dto) {
		if (dto == null) {
			return null;
		}
		MenuEntity menuEntity = referenceMapper.resolve(dto, MenuEntity.class);
		menuEntity.setId(dto.getId());
		menuEntity.setMenuName(dto.getMenuName());
		return menuEntity;
	}
}
