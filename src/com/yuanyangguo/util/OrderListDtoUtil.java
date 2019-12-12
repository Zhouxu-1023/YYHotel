package com.yuanyangguo.util;

import java.util.ArrayList;

import com.yuanyangguo.dto.OrderListDto;
import com.yuanyangguo.vo.Order;


public class OrderListDtoUtil {

	
	public static OrderListDto getDto(ArrayList<Order> orderList , int pageNum , int pageSize , int totalPage){
		OrderListDto orderListDto = new OrderListDto(pageNum, pageSize, totalPage, orderList);
		return orderListDto;
	}
}
