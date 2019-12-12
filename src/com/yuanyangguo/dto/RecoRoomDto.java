package com.yuanyangguo.dto;

/**
 * 推荐房间的Dto
 * 
 * @author zhuyifan
 *
 */
public class RecoRoomDto {
	private int roomType;
	private int roomArea;
	private int bed;
	private int window;
	private double price;
	private int remain;
	private String picUrl = "http://120.55.43.219:8080/img/recoPic/";
	private String RecoInfo;

	public String getRecoInfo() {
		return RecoInfo;
	}

	public void setRecoInfo(String recoInfo) {
		RecoInfo = recoInfo;
	}

	public RecoRoomDto() {
	}

	public RecoRoomDto(int roomType, int roomArea, int bed, int window, double price, int remain) {
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.bed = bed;
		this.window = window;
		this.price = price;
		this.remain = remain;
		this.picUrl = picUrl + String.valueOf(this.roomType) + ".jpg";
		this.RecoInfo = "预订立享开业优惠活动";
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(int roomArea) {
		this.roomArea = roomArea;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "RecoRoomDto [roomType=" + roomType + ", roomArea=" + roomArea + ", bed=" + bed + ", window=" + window
				+ ", price=" + price + ", remain=" + remain + ", picUrl=" + picUrl + "]";
	}
}
