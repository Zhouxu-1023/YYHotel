package com.yuanyangguo.dao;

import java.util.ArrayList;
import java.sql.Date;

import com.yuanyangguo.vo.Order;

public interface IOrderDao {

	public void add(String username , String tel ,int status , int roomType,double price , 
			int roomNum , Date checkInTime , Date checkOutTime , String mail);
	
	public boolean delete();
	
	public void update();
	
	public Order getOrder();
	
	public Order getOrder(String tel , Date inDate , Date outDate);
	
	public ArrayList<Order> getOrderList(int off, int count);
	public ArrayList<Order> getOrderListByStatus(int off, int count, int status);
	public ArrayList<Order> getOrderListByTime(int off, int count, int queryTime);
	public ArrayList<Order> getOrderListByPrice(int off, int count,  int priceMin, int priceMax);
	public ArrayList<Order> getOrderListByStatusAndTime(int off, int count, int status, int queryTime);
	public ArrayList<Order> getOrderListByStatusAndPrice(int off, int count, int status, int priceMin, int priceMax);
	public ArrayList<Order> getOrderListByPriceAndTime(int off, int count, int priceMin, int priceMax, int queryTime);
	public ArrayList<Order> getOrderListByAll(int off, int count, int priceMin, int priceMax, int status, int queryTime);
	
	public int getTotleOfOrder();
	public int getTotleOfHistory();
}
