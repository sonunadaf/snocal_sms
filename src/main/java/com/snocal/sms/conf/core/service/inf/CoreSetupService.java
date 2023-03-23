package com.snocal.sms.conf.core.service.inf;

import java.util.List;

import com.snocal.sms.conf.core.dto.GroupDO;

public interface CoreSetupService {
	public void createApi();

	public void updateApi();

	public void deleteApi();

	public void getApi();

	public void createGroup(GroupDO groupDO);

	public void updateGroup(GroupDO groupDO);

	public void deleteGroup(Long id);

	public List<GroupDO> getGroup(Long id);

}
