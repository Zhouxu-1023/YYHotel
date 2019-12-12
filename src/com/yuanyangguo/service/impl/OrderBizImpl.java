
package com.yuanyangguo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.yuanyangguo.dao.IHistoryDao;
import com.yuanyangguo.dao.IOrderDao;
import com.yuanyangguo.dao.IRoomDao;
import com.yuanyangguo.dao.impl.HistoryDaoImpl;
import com.yuanyangguo.dao.impl.OrderDaoImpl;
import com.yuanyangguo.dao.impl.RoomDaoImpl;
import com.yuanyangguo.service.IOrderBiz;
import com.yuanyangguo.vo.HistoryOrder;
import com.yuanyangguo.vo.Order;
import com.yuanyangguo.vo.Room;

public class OrderBizImpl implements IOrderBiz {

	private IOrderDao orderDao = new OrderDaoImpl();
	private IHistoryDao historyDao = new HistoryDaoImpl();
	private IRoomDao roomDao = new RoomDaoImpl();
	
	@Override
	public boolean add(String name, String tel, String roomType, String pay, String needNum, String checkInTime,
			String checkOutTime, String mail) {
		// 将String类型的时间转为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date checkInDate = null;
		Date checkOutDate = null;
		try {
			checkInDate = sdf.parse(checkInTime);
			checkOutDate = sdf.parse(checkOutTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 转换为sql的Date
		long in = checkInDate.getTime();
		long out = checkOutDate.getTime();
		java.sql.Date inDate = new java.sql.Date(in);
		java.sql.Date outDate = new java.sql.Date(out);
		//根据房间类型随机查找空房间的房间号
		ArrayList<Room> roomList = roomDao.getRoomListByTypeAndStatus(Integer.parseInt(roomType), 1, 0, 1);
		if(roomList.size() != 0){
			Room room = roomList.get(0);
			int roomNumber = room.getRoomNumber();
			// 传入状态Status = 2;(已入住)
			orderDao.add(name, tel, 5, Integer.parseInt(roomType), Double.parseDouble(pay),
					roomNumber, inDate, outDate, mail);
			//将房间表中该房间的状态改为已预订
			roomDao.setStatus(5 , roomNumber);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrder(String tel, String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrderList(int page, int count, String priceMin, String priceMax, String status,
			String queryTime) {
		ArrayList<Order> orderList = new ArrayList<>();
		// 判断筛选条件
		if (status == null && priceMin == null && queryTime == null) {
			// 根据筛选条件查找对应的列表
			orderList = orderDao.getOrderList((page - 1) * count, count);

		} else if (status != null && priceMin == null && queryTime == null) {
			// 筛选条件——状态
			orderList = orderDao.getOrderListByStatus((page - 1) * count, count, Integer.parseInt(status));
		} else if (status != null && priceMin != null && queryTime == null) {
			// 筛选条件——状态、价格
			orderList = orderDao.getOrderListByStatusAndPrice((page - 1) * count, count, Integer.parseInt(status),
					Integer.parseInt(priceMin), Integer.parseInt(priceMax));
		} else if (status != null && priceMin != null && queryTime != null) {
			// 筛选条件——状态、价格、时间
			orderList = orderDao.getOrderListByAll((page - 1) * count, count, Integer.parseInt(priceMin),
					Integer.parseInt(priceMax), Integer.parseInt(status), Integer.parseInt(queryTime));
		} else if (status == null && priceMin != null && queryTime != null) {
			// 筛选条件——价格、时间
			orderList = orderDao.getOrderListByPriceAndTime((page - 1) * count, count, Integer.parseInt(priceMin),
					Integer.parseInt(priceMax), Integer.parseInt(queryTime));
		} else if (status == null && priceMin == null && queryTime != null) {
			// 筛选条件——时间
			orderList = orderDao.getOrderListByTime((page - 1) * count, count, Integer.parseInt(queryTime));
		} else if (status == null && priceMin != null && queryTime == null) {
			// 筛选条件——价格
			orderList = orderDao.getOrderListByPrice((page - 1) * count, count, Integer.parseInt(priceMin),
					Integer.parseInt(priceMax));
		} else if (status != null && priceMin == null && queryTime != null) {
			// 筛选条件——状态、时间
			orderList = orderDao.getOrderListByStatusAndTime((page - 1) * count, count, Integer.parseInt(status),
					Integer.parseInt(queryTime));
		}
		return orderList;
	}

	@Override
	public int allPageOfOrder(int count) {
		int totle = orderDao.getTotleOfOrder();
		if (totle % count == 0) {
			return totle / count;
		}
		return (totle / count + 1);
	}

	@Override
	public int allPageOfHistory(int count) {
		int totle = orderDao.getTotleOfHistory();
		if (totle % count == 0) {
			return totle / count;
		}
		return (totle / count + 1);
	}

	@Override
	public ArrayList<HistoryOrder> getHistoryOrder(String pageNum , String pageSize ,  String orderNum, String roomNum, String name) {
		int page = Integer.parseInt(pageNum);
		int count = Integer.parseInt(pageSize);
		int off = (page-1)*count;
		ArrayList<HistoryOrder> historyList = new ArrayList<>();
		if(orderNum==null && roomNum==null && name==null){
			historyList = historyDao.getHistoryOrder( off, count);
		}else if (orderNum==null && roomNum==null && name!=null) {
			historyList = historyDao.getHistoryOrderByName(name, off, count);
		}else if (orderNum==null && roomNum!=null && name==null) {
			historyList = historyDao.getHistoryByroomNum(Integer.parseInt(roomNum), off, count);
		}else if (orderNum!=null && roomNum==null && name==null) {
			historyList = historyDao.getHistoryByOrderNum(orderNum, off, count);
		}else if (orderNum==null && roomNum!=null && name!=null) {
			historyList = historyDao.getHistoryOrderByName(name, off, count);
		}else if (orderNum!=null && roomNum==null && name!=null) {
			historyList = historyDao.getHistoryByOrderNum(orderNum, off, count);
		}else if (orderNum!=null && roomNum!=null && name==null) {
			historyList = historyDao.getHistoryByOrderNum(orderNum, off, count);
		}else if (orderNum!=null && roomNum!=null && name!=null) {
			historyList = historyDao.getHistoryByOrderNum(orderNum, off, count);
		}
		
		return historyList;
	}

}
