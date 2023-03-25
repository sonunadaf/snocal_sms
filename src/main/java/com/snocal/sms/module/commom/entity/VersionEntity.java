package com.snocal.sms.module.commom.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Value;

@MappedSuperclass
public class VersionEntity extends StatusEntity {

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "current_version")
	@Value("${snocal.product.version}")
	private String currentVersion;

	private String description;

	public VersionEntity() {
		this.createdDate = new Date();
		this.updatedDate = new Date();

	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	@Value("${snocal.product.version}")
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
