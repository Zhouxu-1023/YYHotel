package com.yuanyangguo.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dto.HistoryOrderListDto;
import com.yuanyangguo.dto.OrderListDto;
import com.yuanyangguo.service.IOrderBiz;
import com.yuanyangguo.service.impl.OrderBizImpl;
import com.yuanyangguo.util.OrderListDtoUtil;
import com.yuanyangguo.vo.HistoryOrder;
import com.yuanyangguo.vo.Order;


public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = -5448664541541852638L;
	private IOrderBiz orderBiz = new OrderBizImpl();

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
		// 获取前端发送的数据
		String action = request.getParameter("action");
		String status = request.getParameter("status");
		String queryTime = request.getParameter("queryTime");
		String priceMax = request.getParameter("priceMax");
		String priceMin = request.getParameter("priceMin");
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		//历史订单查询
		String orderNum = request.getParameter("orderNum");
		String roomNum = request.getParameter("roomNum");
		String name = request.getParameter("name");
		

		if ("orderTracking".equals(action)) {//查询订单列表
			
			getOrderList(request, response, status, queryTime, priceMax, priceMin, pageNum, pageSize);
		}else if("historyTracking".equals(action)){//历史订单查询
			int totalPage = orderBiz.allPageOfHistory(Integer.parseInt(pageSize));
			ArrayList<HistoryOrder> historyOrderList = orderBiz.getHistoryOrder(pageNum , pageSize , orderNum , roomNum , name);
			HistoryOrderListDto historyOrderListDto = new HistoryOrderListDto(Integer.parseInt(pageNum), Integer.parseInt(pageSize), totalPage, historyOrderList);
			response.getWriter().println(JSON.toJSONString(historyOrderListDto));
		}

	}

	
	
	//获取订单列表
	private void getOrderList(HttpServletRequest request, HttpServletResponse response, String status, String queryTime,
			String priceMax, String priceMin, String pageNum, String pageSize) throws IOException {
		int count = Integer.parseInt(pageSize);
		int pageNumber = Integer.parseInt(pageNum);// 当前页数
		//获取页面总数——pageSize
		int allPage = orderBiz.allPageOfOrder(count);
		ArrayList<Order> orderList = orderBiz.getOrderList(pageNumber, count , priceMin, priceMax, status , queryTime);
		OrderListDto orderListDto = OrderListDtoUtil.getDto(orderList, pageNumber, count, allPage);
		String data = JSON.toJSONString(orderListDto);
		response.getWriter().println(data);
	}

}
