package com.yuanyangguo.util;

import java.util.ArrayList;

import com.yuanyangguo.dto.RoomListDto;
import com.yuanyangguo.vo.Page;
import com.yuanyangguo.vo.Room;





public class RoomListDtoUtil {
	public static RoomListDto getDto(ArrayList<Room> orderList , Page page){
		RoomListDto orderListDto = new RoomListDto(orderList, page);
		return orderListDto;
	}
}
