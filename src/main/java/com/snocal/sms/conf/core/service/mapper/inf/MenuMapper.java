package com.snocal.sms.conf.core.service.mapper.inf;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.snocal.sms.conf.core.dto.MenuDTO;
import com.snocal.sms.conf.core.entity.MenuEntity;
import com.snocal.sms.conf.core.service.mapper.impl.ReferenceMapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface MenuMapper extends GenericMapper<MenuEntity, MenuDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    MenuEntity asEntity(MenuDTO dto);
}
