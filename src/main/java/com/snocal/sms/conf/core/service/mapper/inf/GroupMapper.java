package com.snocal.sms.conf.core.service.mapper.inf;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.snocal.sms.conf.core.dto.GroupDTO;
import com.snocal.sms.conf.core.entity.GroupEntity;
import com.snocal.sms.conf.core.service.mapper.impl.ReferenceMapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface GroupMapper extends GenericMapper<GroupEntity, GroupDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    GroupEntity asEntity(GroupDTO dto);
}