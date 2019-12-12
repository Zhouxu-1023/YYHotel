package com.yuanyangguo.dto;

import com.yuanyangguo.vo.Admin;

public class AdminDto {
	private boolean isLogin;
	private Admin admin;
	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDto(boolean isLogin, Admin admin) {
		super();
		this.isLogin = isLogin;
		this.admin = admin;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "AdminDto [isLogin=" + isLogin + ", admin=" + admin + "]";
	}
	
}
