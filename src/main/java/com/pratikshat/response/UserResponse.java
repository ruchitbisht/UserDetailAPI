package com.pratikshat.response;

import java.util.Date;

public class UserResponse {

	private String fullName;
	private String country;
	private String image;
	private Date userDOB;
	private Long age;

	public UserResponse(String fullName, String country, String image, Date userDOB, Long age) {
		this.fullName = fullName;
		this.country = country;
		this.image = image;
		this.userDOB = userDOB;
		this.age = age;
	}

	public UserResponse() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}
