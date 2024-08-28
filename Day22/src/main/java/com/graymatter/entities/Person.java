package com.graymatter.entities;


import org.springframework.data.domain.Persistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Entity
@Table(name="Day22Person")
public class Person implements Persistable<Long>{
	@Id
	@Column(name="aadharnum")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long aAdharNum;
	@Column(name="personName")
	@Size(min=3,message="person name must be more than 3 char letters")
	private String name;
	@NotBlank
	@Pattern(regexp="[6789][0-9]{9}",message="mobile number must be of 10 length,starting with either 6,7,8,9")
	private String mobileNum;
	//@Range(min=18,message="Age must be more than 18 to cast vote")
	private int age;
	@Email
	private String email;
	@Transient
	@Builder.Default
	private boolean isNewId=true;
	public Person() {
		super();
	}
	public Person(int aAdharNum, String name, String mobileNum, int age, String email) {
		super();
		this.aAdharNum = aAdharNum;
		this.name = name;
		this.mobileNum = mobileNum;
		this.age = age;
		this.email = email;
	}
	public long getaAdharNum() {
		return aAdharNum;
	}
	public void setaAdharNum(int aAdharNum) {
		this.aAdharNum = aAdharNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [aAdharNum=" + aAdharNum + ", name=" + name + ", mobileNum=" + mobileNum + ", age=" + age
				+ ", email=" + email + "]";
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNewId;
	}
	

}
