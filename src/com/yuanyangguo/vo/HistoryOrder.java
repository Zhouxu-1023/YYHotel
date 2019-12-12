package com.yuanyangguo.vo;


public class HistoryOrder {

	private int orderNum;
	private int roomNum;
	private int roomType;
	private String username;
	private int idCard;
	private int tel;
	private String checkInTime;
	private String checkOutTime;
	private int liveDays;
	private double price;
	
	public HistoryOrder() {
	}

	public HistoryOrder(int orderNum, int roomNum, int roomType, String username, int idCard, int tel, String checkInTime,
			String checkOutTime, int liveDays, double price) {
		super();
		this.orderNum = orderNum;
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.username = username;
		this.idCard = idCard;
		this.tel = tel;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.liveDays = liveDays;
		this.price = price;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getLiveDays() {
		return liveDays;
	}

	public void setLiveDays(int liveDays) {
		this.liveDays = liveDays;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HistoryOrder [orderNum=" + orderNum + ", roomNum=" + roomNum + ", roomType=" + roomType + ", username="
				+ username + ", idCard=" + idCard + ", tel=" + tel + ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + ", liveDays=" + liveDays + ", price=" + price + "]";
	}
	
	
}