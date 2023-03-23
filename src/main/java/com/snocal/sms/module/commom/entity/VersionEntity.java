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

	@Value("${snocal.product.version}")
	@Column(name = "current_version")
	private String currentVersion;

	private String description;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {

		if (this.createdDate != null) {
			this.createdDate = new Date();
		} else {
			this.createdDate = createdDate;
		}
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {

		if (this.updatedDate != null) {
			this.updatedDate = new Date();
		} else {
			this.updatedDate = updatedDate;
		}

	}

	public String getCurrentVersion() {
		return currentVersion;
	}

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
