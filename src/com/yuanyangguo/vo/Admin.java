package com.yuanyangguo.vo;

public class Admin {
	
    private String username;
    private String password;
    private String name;
    private String department;
    private String duty;
    private String phone;
    private String wechat;
    private String hiredate;
    private String mail;
    private String signature;
    private String url;
	public Admin() {
	}
	public Admin(String username, String password, String name, String department, String duty, String phone,
			String wechat, String hiredate, String mail, String signature, String url) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.department = department;
		this.duty = duty;
		this.phone = phone;
		this.wechat = wechat;
		this.hiredate = hiredate;
		this.mail = mail;
		this.signature = signature;
		this.url = url;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", name=" + name + ", department="
				+ department + ", duty=" + duty + ", phone=" + phone + ", wechat=" + wechat + ", hiredate=" + hiredate
				+ ", mail=" + mail + ", signature=" + signature + ", url=" + url + "]";
	}
	
    
     
}
