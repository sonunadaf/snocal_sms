package com.snocal.sms.module.entity.student;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;



import com.snocal.sms.module.commom.entity.PrimaryKeyEntity;

@Entity
@Table(name = "STUDENT")
public class StudentEntity extends PrimaryKeyEntity{
	
	private String name;
	private Date dateOfBirth;
	private String contactNo;
	private String address;
	

}
