package com.pratikshat.request;

import java.util.Date;

public class UserRequest {

	private String firstName;
	private String surname;
	private String country;
	private String image;
	private Date userDOB;
	private Long age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurName(String surname) {
		this.surname = surname;
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

	public UserRequest() {
	}

	public UserRequest(String firstName, String surname, String country, String image, Date userDOB, Long age) {

		this.firstName = firstName;
		this.surname = surname;
		this.country = country;
		this.image = image;
		this.userDOB = userDOB;
		this.age = age;
	}

}
