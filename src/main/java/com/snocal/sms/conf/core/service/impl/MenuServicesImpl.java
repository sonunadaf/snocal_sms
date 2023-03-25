package com.snocal.sms.conf.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snocal.sms.conf.core.entity.MenuEntity;
import com.snocal.sms.conf.core.repository.MenuRepository;
import com.snocal.sms.conf.core.service.inf.IMenuServices;

@Service
@Transactional
public class MenuServicesImpl implements IMenuServices {

	private final MenuRepository repository;

	public MenuServicesImpl(MenuRepository repository) {
		this.repository = repository;
	}

	@Override
	public MenuEntity save(MenuEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<MenuEntity> save(List<MenuEntity> entities) {
		return (List<MenuEntity>) repository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		Optional<MenuEntity> optional = findById(id);
		if (optional.isPresent()) {
			MenuEntity menuEntity = optional.get();
			menuEntity.setActive(false);
			menuEntity.setDeleted(false);
			save(menuEntity);
		}
	}

	@Override
	public Optional<MenuEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<MenuEntity> findAll() {
		return (List<MenuEntity>) repository.findAll();
	}

	@Override
	public Page<MenuEntity> findAll(Pageable pageable) {
		Page<MenuEntity> entityPage = repository.findAll(pageable);
		List<MenuEntity> entities = entityPage.getContent();
		return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
	}

	@Override
	public MenuEntity update(MenuEntity entity, Long id) {
		Optional<MenuEntity> optional = findById(id);
		if (optional.isPresent()) {
			return save(entity);
		}
		return null;
	}
}
