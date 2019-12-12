package com.yuanyangguo.vo;


public class Order {
	
	private String orderTime;
	private int type;
	private double price;
	private String username;
	private String tel;
	private int status;
	public Order() {
	}
	public Order(String orderTime, int type, double price, String username, String tel, int status) {
		super();
		this.orderTime = orderTime;
		this.type = type;
		this.price = price;
		this.username = username;
		this.tel = tel;
		this.status = status;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderTime=" + orderTime + ", type=" + type + ", price=" + price + ", username=" + username
				+ ", tel=" + tel + ", status=" + status + "]";
	}
	
	
}
