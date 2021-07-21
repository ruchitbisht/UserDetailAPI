package com.pratikshat.request;

public class FilterRequest {

	private String firstName;
	private String surname;
	private String country;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public FilterRequest(String firstName, String surname, String country) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.country = country;
	}
	public FilterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
