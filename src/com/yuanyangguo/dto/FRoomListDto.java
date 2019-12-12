package com.yuanyangguo.dto;

import java.util.ArrayList;

import com.yuanyangguo.vo.Room;

public class FRoomListDto {

	private ArrayList<Room> roomList;
	private String PicUrl;
	public FRoomListDto() {
		// TODO Auto-generated constructor stub
	}
	
	public FRoomListDto(ArrayList<Room> roomList, String picUrl) {
		super();
		this.roomList = roomList;
		PicUrl = picUrl;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}
	
	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	@Override
	public String toString() {
		return "FRoomListDto [roomList=" + roomList + ", PicUrl=" + PicUrl + "]";
	}

	
}
