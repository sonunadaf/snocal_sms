package com.snocal.sms.module.commom.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StatusEntity {

	@Column(name = "id_active", columnDefinition = "boolean default true")
	private boolean isActive;

	@Column(name = "id_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
