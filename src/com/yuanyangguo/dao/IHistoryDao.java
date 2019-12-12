package com.yuanyangguo.dao;

import java.util.ArrayList;

import com.yuanyangguo.vo.HistoryOrder;

public interface IHistoryDao {

	public ArrayList<HistoryOrder> getHistoryOrder(int off , int count);

	public ArrayList<HistoryOrder> getHistoryOrderByName(String name , int off , int count);

	public ArrayList<HistoryOrder> getHistoryByroomNum(int roomNum , int off , int count);

	public ArrayList<HistoryOrder> getHistoryByOrderNum(String orderNum , int off , int count);

}
