package com.yuanyangguo.dao;

import java.util.ArrayList;

import com.yuanyangguo.vo.Room;

public interface IRoomDao {
	
	//所有房间
	public ArrayList<Room> getRoomList(int off, int count);
	//根据楼层查看房间
	public ArrayList<Room> getRoomListByFloor(int floor, int off, int count);
	//根据房间类型查看房间
	public ArrayList<Room> getRoomListByType(int room_type, int off, int count);
	//根据房间状态查看房间
	public ArrayList<Room> getRoomListByStatus(int status, int off, int count);
	//楼层，类型
	public ArrayList<Room> getRoomListByFloorAndType(int floor,int room_type, int off, int count);
	//楼层，状态
	public ArrayList<Room> getRoomListByFloorAndStatus(int floor,int status, int off, int count);
	//类型，状态
	public ArrayList<Room> getRoomListByTypeAndStatus(int room_type,int status, int off, int count);
	//楼层，类型，状态
	public ArrayList<Room> getRoomListByAll(int floor,int room_type,int status, int off, int count);
	//房间总数
	public int getRoomSum();
	
	public Room getRoom(int room_number);
	
	public Room getRoomByRoomNumber(int room_number);
	
	public ArrayList<Room> getRoomListByRoomType(int room_type);
	
	
	
	//获取房间列表(可能需重载该方法)
	//public ArrayList<Room> getRoom(int hotelId);
	//获取推荐房间列表
	public ArrayList<Room> getRecommendRoom(int hotelId);
	//根据房间状态统计房间数量
	public int getAmountByStatus(int hotelId,int status);
	//统计房间总数
	public int getAmount(int hotelId);
	//统计推荐房间数量
	public int getRecoAmount(int hotelId,int roomType);
	
	//根据修改某个房间的房间状态
	public void setStatus(int status , int roomNum);
}
