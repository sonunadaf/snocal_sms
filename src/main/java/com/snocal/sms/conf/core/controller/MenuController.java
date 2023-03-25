package com.snocal.sms.conf.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.snocal.sms.conf.core.dto.MenuDTO;
import com.snocal.sms.conf.core.entity.MenuEntity;
import com.snocal.sms.conf.core.service.inf.IMenuServices;
import com.snocal.sms.conf.core.service.mapper.inf.MenuMapper;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IMenuServices menuService;
	@Autowired
	@Qualifier("snMenuMapperImpl")
	private MenuMapper menuMapper;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public MenuDTO save(@RequestBody MenuDTO menuDTO) {
		MenuEntity menuEntity = menuMapper.asEntity(menuDTO);
		return menuMapper.asDTO(menuService.save(menuEntity));
	}

	@GetMapping("/getMenu/{id}")
	public MenuDTO findById(@PathVariable("id") Long id) {
		MenuEntity menu = menuService.findById(id).orElse(null);
		return menuMapper.asDTO(menu);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		menuService.deleteById(id);
	}

	@GetMapping("/getAll")
	public List<MenuDTO> list() {
		return menuMapper.asDTOList(menuService.findAll());
	}

	@GetMapping("/page-query")
	public Page<MenuDTO> pageQuery(Pageable pageable) {
		Page<MenuEntity> menuPage = menuService.findAll(pageable);
		List<MenuDTO> dtoList = menuPage.stream().map(menuMapper::asDTO).collect(Collectors.toList());
		return new PageImpl<>(dtoList, pageable, menuPage.getTotalElements());
	}

	@PutMapping("/update/{id}")
	public MenuDTO update(@RequestBody MenuDTO menuDTO, @PathVariable("id") Long id) {
		MenuEntity menu = menuMapper.asEntity(menuDTO);
		return menuMapper.asDTO(menuService.update(menu, id));
	}
}
