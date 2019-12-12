package com.yuanyangguo.dto;

import java.util.ArrayList;

import com.yuanyangguo.vo.Page;
import com.yuanyangguo.vo.Room;



public class RoomListDto {
	private ArrayList<Room> roomList;
	private Page page;
	
	public RoomListDto() {
		
	}

	public RoomListDto(ArrayList<Room> roomList, Page page) {
		super();
		this.roomList = roomList;
		this.page = page;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "RoomListDto [roomList=" + roomList + ", page=" + page + "]";
	}
	
	
	
}
