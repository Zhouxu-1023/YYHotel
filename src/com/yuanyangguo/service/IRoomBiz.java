package com.yuanyangguo.service;

import java.util.ArrayList;


import com.yuanyangguo.vo.Room;

public interface IRoomBiz {

	public String getRecoRoomDtoList(int hotelId);

	public String getRoomStatus(int hotelId);
	
	//获取房间列表
	public ArrayList<Room> getRoomList(int floor,int room_type,int status, int page, int count);
	
	public int getStuSum();
		
	public int getAllPage(int count);
	
	public Room getRoom(int room_number);

}
