package com.yuanyangguo.util;

import java.util.ArrayList;
import com.yuanyangguo.dto.RecoRoomDto;
import com.yuanyangguo.vo.Room;
/**
 * 推荐房间的Dto工具类
 * @author zhuyifan
 *
 */
public class RecoRoomDtoUtil {
	public static RecoRoomDto getRecoRoomDto(Room room, int remain) {
		RecoRoomDto recoRoomDto = new RecoRoomDto();
		recoRoomDto.setBed(room.getBed());
		recoRoomDto.setPrice(room.getPrice());
		recoRoomDto.setRemain(remain);
		recoRoomDto.setRoomArea(room.getRoomArea());
		recoRoomDto.setRoomType(room.getRoomType());
		recoRoomDto.setWindow(room.getWindow());
		return recoRoomDto;
	}

	public static ArrayList<RecoRoomDto> getRecoRoomDtoList(ArrayList<Room> roomList) {
		ArrayList<RecoRoomDto> recoRoomDtoList = new ArrayList<>();
		return recoRoomDtoList;
	}
}
