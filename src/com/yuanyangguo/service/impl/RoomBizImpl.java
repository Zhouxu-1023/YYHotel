package com.yuanyangguo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dto.RecoRoomDto;
import com.yuanyangguo.dto.RoomStatusDto;
import com.yuanyangguo.dao.IRoomDao;
import com.yuanyangguo.dao.impl.RoomDaoImpl;
import com.yuanyangguo.service.IRoomBiz;
import com.yuanyangguo.vo.Room;

public class RoomBizImpl implements IRoomBiz {
	private IRoomDao roomDao = new RoomDaoImpl();

	@Override
	public ArrayList<Room> getRoomList(int floor, int room_type, int status, int page, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		if(floor == 0 && room_type == 0 && status == 0){
			//全部房间
			roomList = roomDao.getRoomList((page - 1) * count, count);
		}else if(floor != 0 && room_type == 0 && status == 0){
			//按楼层
			roomList = roomDao.getRoomListByFloor(floor, (page - 1) * count, count);
		}else if(floor == 0 && room_type != 0 && status == 0){
			//按类型
			roomList = roomDao.getRoomListByType(room_type, (page - 1) * count, count);
		}else if(floor == 0 && room_type == 0 && status != 0){
			//按状态
			roomList = roomDao.getRoomListByStatus(status, (page - 1) * count, count);
		}else if(floor != 0 && room_type != 0 && status == 0){
			//按楼层和类型
			roomList = roomDao.getRoomListByFloorAndType(floor, room_type, (page - 1) * count, count);
		}else if(floor != 0 && room_type == 0 && status != 0){
			//按楼层和状态
			roomList = roomDao.getRoomListByFloorAndStatus(floor, status, (page - 1) * count, count);
		}else if(floor == 0 && room_type != 0 && status != 0){
			//按类型和状态
			roomList = roomDao.getRoomListByTypeAndStatus(room_type, status, (page - 1) * count, count);
		}else if(floor != 0 && room_type != 0 && status != 0){
			//按楼层，类型和状态
			roomList = roomDao.getRoomListByAll(floor, room_type, status, (page - 1) * count, count);
		}
		
		return roomList;
	}
	@Override
	public int getStuSum() {//获取总房间数
		return roomDao.getRoomSum();
	}

	@Override
	public int getAllPage(int count) {//获取总页数
		int roomSum = roomDao.getRoomSum();
		if(roomSum%count == 0){
			return roomSum/count;
		}
		return roomSum/count+1;
	}

	@Override
	public Room getRoom(int room_number) {//通过房间号查询房间
		return roomDao.getRoom(room_number);
	}
	@Override
	public String getRecoRoomDtoList(int hotelId) {
		// 利用set对推荐房间按类型去重，统计每个类型的房间数量
		HashSet<Integer> roomTypeSet = new HashSet<>();
		ArrayList<Room> roomList = roomDao.getRecommendRoom(hotelId);
		ArrayList<RecoRoomDto> recoRoomDtoList = new ArrayList<>();
		for (Room aRoom : roomList) {
			int roomType = aRoom.getRoomType();
			if (!roomTypeSet.contains(roomType)) {
				// 统计该类型房间总数
				int remain = roomDao.getRecoAmount(hotelId, roomType);
				// 创建该类型房间的Dto并存入recoRoomDtoList中
				RecoRoomDto recoRoomDto = new RecoRoomDto(roomType, aRoom.getRoomArea(), aRoom.getBed(),
						aRoom.getWindow(), aRoom.getPrice(), remain);
				recoRoomDtoList.add(recoRoomDto);
				roomTypeSet.add(roomType);
			}
		}
		return JSON.toJSONString(recoRoomDtoList);
	}

	@Override
	public String getRoomStatus(int hotelId) {
		int emptyRoom = roomDao.getAmountByStatus(hotelId, 1);
		int busyRoom = roomDao.getAmountByStatus(hotelId, 2);
		int cleanRoom = roomDao.getAmountByStatus(hotelId, 3);
		int fixRoom = roomDao.getAmountByStatus(hotelId, 4);
		int allRoom = roomDao.getAmount(hotelId);
		
		
		double emptyRate = new BigDecimal((float)emptyRoom/allRoom).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		emptyRate = 100*emptyRate;
		
		double busyRate = new BigDecimal((float)busyRoom/allRoom).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		busyRate = 100*busyRate;
		
		double cleanRate = new BigDecimal((float)cleanRoom/allRoom).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		cleanRate = 100*cleanRate;
		
		double fixRate = new BigDecimal((float)fixRoom/allRoom).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		fixRate = 100*fixRate;
		
		RoomStatusDto roomStatusDto = new RoomStatusDto(emptyRoom, emptyRate, busyRoom, busyRate, cleanRoom, cleanRate, fixRoom, fixRate);
		return JSON.toJSONString(roomStatusDto);
	}

}
