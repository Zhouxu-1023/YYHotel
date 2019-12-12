package com.yuanyangguo.dto;

import java.util.ArrayList;

import com.yuanyangguo.vo.HistoryOrder;



public class HistoryOrderListDto {

	private int pageNum;
	private int pageSize;
	private int totalPage;
	private ArrayList<HistoryOrder> historyOrderList;
	
	public HistoryOrderListDto() {
		// TODO Auto-generated constructor stub
	}

	public HistoryOrderListDto(int pageNum, int pageSize, int totalPage, ArrayList<HistoryOrder> historyOrderList) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.historyOrderList = historyOrderList;
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

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public ArrayList<HistoryOrder> getHistoryOrderList() {
		return historyOrderList;
	}

	public void setHistoryOrderList(ArrayList<HistoryOrder> historyOrderList) {
		this.historyOrderList = historyOrderList;
	}

	@Override
	public String toString() {
		return "HistoryOrderListDto [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", historyOrderList=" + historyOrderList + "]";
	}
	
	
	
}
