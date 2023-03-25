package com.snocal.sms.conf.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snocal.sms.conf.core.entity.GroupEntity;
import com.snocal.sms.conf.core.repository.GroupRepository;
import com.snocal.sms.conf.core.service.inf.IGroupServices;

@Service
@Transactional
public class GroupServicesImpl implements IGroupServices {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public GroupEntity save(GroupEntity entity) {
		return groupRepository.save(entity);
	}

	@Override
	public List<GroupEntity> save(List<GroupEntity> entities) {
		return (List<GroupEntity>) groupRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		Optional<GroupEntity> optional = findById(id);
		if (optional.isPresent()) {
			GroupEntity groupEntity = optional.get();
			groupEntity.setActive(false);
			groupEntity.setDeleted(true);
			save(groupEntity);
		}
	}

	@Override
	public Optional<GroupEntity> findById(Long id) {
		return groupRepository.findById(id);
	}

	@Override
	public List<GroupEntity> findAll() {
		return (List<GroupEntity>) groupRepository.findAll();
	}

	@Override
	public Page<GroupEntity> findAll(Pageable pageable) {
		Page<GroupEntity> entityPage = groupRepository.findAll(pageable);
		List<GroupEntity> entities = entityPage.getContent();
		return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
	}

	@Override
	public GroupEntity update(GroupEntity entity, Long id) {
		Optional<GroupEntity> optional = findById(id);
		if (optional.isPresent()) {
			return save(entity);
		}
		return null;
	}

}
