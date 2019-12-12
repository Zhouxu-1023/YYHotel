package com.yuanyangguo.vo;

public class Costomer {

	private int id;
	private String sex;
	private String surname;
	private String name;
	private String birthday;
	private String email;
	private String password;
	private String address;
	private String phone_number;
	
 	
	
	public Costomer() {
 	}
	
	
	public Costomer(String sex, String surname, String name, String birthday, String email, String password,
			String address, String phone_number) {
 		this.sex = sex;
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
	}


	public Costomer(int id, String sex, String surname, String name, String birthday, String email, String password,
			String address, String phone_number) {
 		this.id = id;
		this.sex = sex;
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
