package com.yuanyangguo.dto;

import java.util.ArrayList;

import com.yuanyangguo.vo.Order;

public class OrderListDto {

	private int pageNum;
	private int pageSize;
	private int totalPage;
	private ArrayList<Order> OrderList;
	
	public OrderListDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderListDto(int pageNum, int pageSize, int totalPage, ArrayList<Order> orderList) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		OrderList = orderList;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalSize) {
		this.totalPage = totalSize;
	}

	public ArrayList<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		OrderList = orderList;
	}

	@Override
	public String toString() {
		return "OrderListDto [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", OrderList=" + OrderList + "]";
	}

	

	
	
}
