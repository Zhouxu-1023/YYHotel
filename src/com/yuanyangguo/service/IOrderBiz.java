package com.yuanyangguo.service;

import java.util.ArrayList;

import com.yuanyangguo.vo.HistoryOrder;
import com.yuanyangguo.vo.Order;

public interface IOrderBiz {

	// 添加客户信息
	public boolean add(String name , String tel , String needNum, String pay, String roomNum , String checkInTime,
			String checkOutTime, String mail);

	// 删除客户信息
	public boolean delete();

	// 修改客户信息
	public void update();

	// 通过电话号码或者邮箱地址查询客户信息
	public Order getOrder(String tel, String mail);

	
	// 分页查询，根据查询条件获取订单列表
	public ArrayList<Order> getOrderList(int page, int count , String priceMin , String priceMax , String status , String queryTime);
	
	//获取订单总数
	public int allPageOfOrder(int count);
	
	//获取订单总数
	public int allPageOfHistory(int count);

	//获取历史订单
	public ArrayList<HistoryOrder> getHistoryOrder(String pageNum, String pageSize, String orderNum, String roomNum, String name);



}
