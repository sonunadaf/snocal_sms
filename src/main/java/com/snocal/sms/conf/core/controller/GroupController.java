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

import com.snocal.sms.conf.core.dto.GroupDTO;
import com.snocal.sms.conf.core.entity.GroupEntity;
import com.snocal.sms.conf.core.service.inf.IGroupServices;
import com.snocal.sms.conf.core.service.mapper.inf.GroupMapper;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private IGroupServices groupService;

	@Autowired
	@Qualifier("snGroupMapperImpl")
	private GroupMapper groupMapper;

	/*
	 * public GroupController(IGroupServices groupService, IGroupMapper groupMapper)
	 * { this.groupService = groupService; this.groupMapper = groupMapper; }
	 */

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public GroupDTO save(@RequestBody GroupDTO groupDTO) {
		GroupEntity group = groupMapper.asEntity(groupDTO);
		return groupMapper.asDTO(groupService.save(group));
	}

	@GetMapping("/find/{id}")
	public GroupDTO findById(@PathVariable("id") Long id) {
		GroupEntity group = groupService.findById(id).orElse(null);
		return groupMapper.asDTO(group);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		groupService.deleteById(id);
	}

	@GetMapping("/getAll")
	public List<GroupDTO> list() {
		return groupMapper.asDTOList(groupService.findAll());
	}

	@GetMapping("/page-query")
	public Page<GroupDTO> pageQuery(Pageable pageable) {
		Page<GroupEntity> groupPage = groupService.findAll(pageable);
		List<GroupDTO> dtoList = groupPage.stream().map(groupMapper::asDTO).collect(Collectors.toList());
		return new PageImpl<>(dtoList, pageable, groupPage.getTotalElements());
	}

	@PutMapping("/update/{id}")
	public GroupDTO update(@RequestBody GroupDTO groupDTO, @PathVariable("id") Long id) {
		GroupEntity group = groupMapper.asEntity(groupDTO);
		return groupMapper.asDTO(groupService.update(group, id));
	}

}
