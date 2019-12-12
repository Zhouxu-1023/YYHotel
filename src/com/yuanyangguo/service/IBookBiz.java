package com.yuanyangguo.service;


import com.yuanyangguo.vo.Book;
import com.yuanyangguo.vo.Room;

public interface IBookBiz {
	
	//判断是否预订成功，成功返回true,否则返回false
	public boolean isBook(String tel , String checkInTime , String checkOutTime);
	//判断支付金额是否与房间价格一致
	public boolean isPay(String roomNum , String pay , String needNum);

	public Book getBook();
	//查找房间
	public Room getRoom(String roomNum);
	//查找房间（List）
	public String getRoomList(String roomType ,  String needNum);
}
