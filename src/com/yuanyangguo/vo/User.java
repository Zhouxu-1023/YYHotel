package com.yuanyangguo.vo;

/**
 * 
 * @author zhuyifan
 *
 */
public class User {
	private String name;
	private String sex;
	private int age;
	private String phone_number;
	private String type;
	private String username;
	private String password;

	public User() {
	}

	public User(String name, String sex, int age, String phone_number, String type, String username, String password) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone_number = phone_number;
		this.type = type;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age + ", phone_number=" + phone_number + ", type="
				+ type + ", username=" + username + ", password=" + password + "]";
	}

}
