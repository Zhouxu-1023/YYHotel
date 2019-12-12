package com.yuanyangguo.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dto.RoomListDto;
import com.yuanyangguo.service.IRoomBiz;
import com.yuanyangguo.service.impl.RoomBizImpl;
import com.yuanyangguo.util.RoomListDtoUtil;
import com.yuanyangguo.vo.Page;
import com.yuanyangguo.vo.Room;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomBiz roomBiz = new RoomBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		String hotelId = request.getParameter("hotelId");
		String floor = request.getParameter("floor");
		String room_type = request.getParameter("room_type");
		String status = request.getParameter("status");
		String room_number = request.getParameter("room_number");
		String page = request.getParameter("page");

		if (action.equals("getReco")) {// 获取推荐房间
			String jsonRecoRoomDtoList = roomBiz.getRecoRoomDtoList(Integer.valueOf(hotelId));
			response.getWriter().println(jsonRecoRoomDtoList);
		} else if (action.equals("getStats")) {// 获取各种房间数量及百分比
			String jsonRoomStatus = roomBiz.getRoomStatus(Integer.valueOf(hotelId));
			response.getWriter().println(jsonRoomStatus);
		}

		if ("hotelRoom".equals(action)) {
			getRoomList(response, floor, room_type, status, page);
		} else if ("room_number".equals(action)) {
			Room getRoom = roomBiz.getRoom(Integer.parseInt(room_number));
			String data = JSON.toJSONString(getRoom);
			response.getWriter().println(data);
		}

	}

	private void getRoomList(HttpServletResponse response, String floor, String room_type, String status,
			String pagenum) throws IOException {
		int pageSize = 25;
		int page = Integer.parseInt(pagenum);// 当前页数
		// String url = "RoomServlet?action=hotelRoom&pagenum=";
		// 获取页面总数——pageSize
		int allPage = roomBiz.getAllPage(pageSize);// 获取总页数
		Page p = new Page(pageSize, page, allPage);

		ArrayList<Room> roomList = roomBiz.getRoomList(Integer.parseInt(floor), Integer.parseInt(room_type),
				Integer.parseInt(status), allPage, pageSize);

		RoomListDto roomListDto = RoomListDtoUtil.getDto(roomList, p);
		String data = JSON.toJSONString(roomListDto);
		response.getWriter().println(data);
	}

}
