package com.sripal.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;


@Data
@Entity
@Table(name="SSN_ID")
public class SsnidEntity {
	
	@Id
	@GenericGenerator(name="ssnidno_seq",strategy="com.sripal.Generator.CustomSsnId")
	@GeneratedValue(generator="ssnidno_seq")
	
	private String ssnid;

	@NotEmpty(message="*please Enter The User Name")
	private String name;
	
	@javax.validation.constraints.NotNull(message="*please Enter The Age")
	private int age;
	
	@NotEmpty(message="*please enter the gender")
	private String gender;
	
	@NotEmpty(message="*please enter the date of birth")
	private String dob;
	
	@Email()
	@NotEmpty(message="*please enter the email")
	private String email;
	
	@NotEmpty(message="*please enter the password")
	private String password;
	
	@javax.validation.constraints.NotNull(message="*please enter the mobile number")
	private long mobile;
	
	@NotEmpty(message="*please enter the address")
	private String address;
	
	
}
