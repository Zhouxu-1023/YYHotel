package com.yuanyangguo.vo;

public class CostomerDto {

	private Costomer costomer;
	//判断是否登录成功
	private boolean isLogin;
	
 	
	
	//对象和登陆的构造方法
	public CostomerDto(Costomer costomer, boolean isLogin) {
 		this.costomer = costomer;
		this.isLogin = isLogin;
	}
	
	
	
	@Override
	public String toString() {
		return "CostomerDto [costomer=" + costomer + ", isLogin=" + isLogin + "]";
	}



	public CostomerDto() {
 	}
	
	public Costomer getCostomer() {
		return costomer;
	}
	public void setCostomer(Costomer costomer) {
		this.costomer = costomer;
	}
	public boolean getIsLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	
 }
