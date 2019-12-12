package com.yuanyangguo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.service.IBookBiz;
import com.yuanyangguo.service.IOrderBiz;
import com.yuanyangguo.service.impl.BookBizImpl;
import com.yuanyangguo.service.impl.OrderBizImpl;


public class BookServlet extends HttpServlet {
	
	private IBookBiz bookBiz = new BookBizImpl();
	private IOrderBiz orderBiz = new OrderBizImpl();

	private static final long serialVersionUID = -6216935403515254015L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取前端发来的数据
		System.out.println(request);
		String action = request.getParameter("action");
		String roomType = request.getParameter("roomType");
		String checkInTime = request.getParameter("checkInTime");
		String checkOutTime = request.getParameter("checkOutTime");
		String needNum = request.getParameter("needNum");
		String inName = request.getParameter("name");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String pay = request.getParameter("pay");

		
		
		System.out.println(roomType);
		System.out.println(needNum);
		
		if("foundRoom".equals(action)){//预订房间查找
			String roomList = bookBiz.getRoomList(roomType ,  needNum);
			response.getWriter().println(roomList);
			System.out.println(roomList);
		}else if("book".equals(action)){//预定
			String name = new String(inName.getBytes("iso-8859-1"), "utf-8");
			doBook(response, needNum, roomType, checkInTime, checkOutTime, name, mail, tel, pay);
		}
	}

	
	
	//预订
	private void doBook(HttpServletResponse response, String needNum, String roomType, String checkInTime,
			String checkOutTime, String name, String mail, String tel, String pay) throws IOException {
		//预订成功条件：支付金额与房间价格一致
		if(bookBiz.isPay(roomType , pay , needNum)){//支付金额正确
			if(bookBiz.isBook(tel , checkInTime , checkOutTime)){//可以预定
				//将信息添加到订单列表中
				boolean isAdd = orderBiz.add(name, tel, roomType, pay, needNum, checkInTime, checkOutTime,mail);
				if(isAdd){
					//返回前端结果
					response.getWriter().println(JSON.toJSONString(true));
				}else{
					response.getWriter().println(JSON.toJSONString(false));
				}
			}else{//订单重复，不能预订
				response.getWriter().println(JSON.toJSONString(false));
			}
		}else{//支付金额不正确
			response.getWriter().println(JSON.toJSONString(false));
		}
	}

}
