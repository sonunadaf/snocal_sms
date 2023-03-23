package com.snocal.sms.conf.core.service.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snocal.sms.conf.core.dto.GroupDO;
import com.snocal.sms.conf.core.entity.GroupEntity;
import com.snocal.sms.conf.core.repository.GroupRepository;
import com.snocal.sms.conf.core.service.inf.CoreSetupService;

@Service
public class CoreSetupServiceImpl implements CoreSetupService {

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public void createApi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateApi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteApi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getApi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGroup(GroupDO groupDO) {
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setGroupName(groupDO.getGroupName());
		groupRepository.save(groupEntity);
	}

	@Override
	public void updateGroup(GroupDO groupDO) {
		GroupEntity groupEntity = groupRepository.findById(groupDO.getId()).get();
		groupEntity.setGroupName(groupDO.getGroupName());
		groupRepository.save(groupEntity);

	}

	@Override
	public void deleteGroup(Long id) {
		GroupEntity groupEntity = groupRepository.findById(id).get();
		groupEntity.setActive(false);
		groupEntity.setDeleted(true);
		groupRepository.save(groupEntity);

	}

	@Override
	public List<GroupDO> getGroup(Long id) {
		List<GroupDO> groupDOs = new ArrayList<>();
		if (id != null) {
			GroupEntity groupEntity = groupRepository.findById(id).get();
			GroupDO groupDO = new GroupDO();
			convertGroupEntityToDO(groupEntity, groupDO);
			groupDOs.add(groupDO);
			return groupDOs;
		} else {
			List<GroupEntity> groupEntities = groupRepository.findAll();
			for (GroupEntity groupEntity : groupEntities) {
				GroupDO groupDO = new GroupDO();
				convertGroupEntityToDO(groupEntity, groupDO);
				groupDOs.add(groupDO);
			}
			return groupDOs;
		}
	}

	private void convertGroupEntityToDO(GroupEntity entity, GroupDO groupDO) {
		groupDO.setId(entity.getId());
		groupDO.setGroupName(entity.getGroupName());
	}

}
