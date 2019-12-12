package com.yuanyangguo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dao.IOrderDao;
import com.yuanyangguo.dao.IRoomDao;
import com.yuanyangguo.dao.impl.OrderDaoImpl;
import com.yuanyangguo.dao.impl.RoomDaoImpl;
import com.yuanyangguo.dto.FRoomListDto;
import com.yuanyangguo.service.IBookBiz;
import com.yuanyangguo.vo.Book;
import com.yuanyangguo.vo.Order;
import com.yuanyangguo.vo.Room;

public class BookBizImpl implements IBookBiz {
	private IOrderDao orderDao = new OrderDaoImpl();
	private IRoomDao roomDao = new RoomDaoImpl();
//	IRoomDao roomDao = new RoomDao();

	@Override
	public boolean isBook(String tel , String checkInTime , String checkOutTime) {
		//查询房间类型及数量是否满足预订条件(返回房间列表)
		/*
		 * 1、根据房间号查询订单列表中是否有相同信息的订单，查询信息包括房间号、电话、入住时间、离店时间等
		 */
		//将String类型的时间转为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date checkInDate = null;
		Date checkOutDate = null;
		try {
			checkInDate = sdf.parse(checkInTime);
			checkOutDate = sdf.parse(checkOutTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//转换为sql的Date
		long in  = checkInDate.getTime();
		long out  = checkOutDate.getTime();
		java.sql.Date inDate = new java.sql.Date(in);
		java.sql.Date  outDate = new java.sql.Date(out);
		
		Order order = orderDao.getOrder(tel, inDate , outDate);
		if(order != null){//有相同订单，不可预订
			return false;
		}
		return true;
	}

	
	



	@Override
	public boolean isPay(String roomType, String pay , String needNum) {
		//获取房间对象
		int needNumber = Integer.parseInt(needNum);
		ArrayList<Room> roomList = roomDao.getRoomListByRoomType(Integer.parseInt(roomType));
		Room room = roomList.get(0);
		if(room.getPrice() == (Double.parseDouble(pay) * needNumber)){
			return true;
		}
		return false;
	}

	@Override
	public Book getBook() {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public Room getRoom(String roomNum) {
		Room room = roomDao.getRoom(Integer.parseInt(roomNum));//通过房间id查找
		return room;
	}

	@Override
	public String getRoomList(String roomType ,  String needNum) {
		ArrayList<Room> roomList = roomDao.getRoomListByRoomType(Integer.parseInt(roomType));
		int type = 0;
		String PicUrl = null;
		for (Room room : roomList) {
			type = room.getRoomType();
		}
		//根据房间类型的不同，返回不同的图片地址
		switch(type){
		case 1:
			PicUrl = "http://120.55.43.219:8080/img/Room/1.jpg";
			break;
		case 2:
			PicUrl = "http://120.55.43.219:8080/img/Room/2.jpg";
			break;
		case 3:
			PicUrl = "http://120.55.43.219:8080/img/Room/3.jpg";
			break;
		case 4:
			PicUrl = "http://120.55.43.219:8080/img/Room/4.jpg";
			break;
		case 5:
			PicUrl = "http://120.55.43.219:8080/img/Room/5.jpg";
			break;
		case 6:
			PicUrl = "http://120.55.43.219:8080/img/Room/6.jpg";
			break;
		}
		FRoomListDto fRoomListDto = new FRoomListDto(roomList , PicUrl);
		return JSON.toJSONString(fRoomListDto);
	}





	
	
	

}
