package com.yuanyangguo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.yuanyangguo.dao.IHistoryDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.HistoryOrder;

public class HistoryDaoImpl implements IHistoryDao{

	@Override
	public ArrayList<HistoryOrder> getHistoryOrder(int off, int count) {
		ArrayList<HistoryOrder> historyList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status>3 limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, off);
			statement.setInt(2, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				int orderNum = resultSet.getInt("order_number");
				int roomNum = resultSet.getInt("room_number");
				int roomType = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				int tel = resultSet.getInt("tel");
				int liveDays = resultSet.getInt("live_days");
				int idCard = resultSet.getInt("idcard");
				Date checkInTime = resultSet.getDate("checkin_time");
				Date checkOutTime = resultSet.getDate("checkout_time");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String inTime = sdf.format(checkInTime);
				String outTime = sdf.format(checkOutTime);
				//将信息封装为order对象
				historyList.add(new HistoryOrder(orderNum, roomNum, roomType, username, idCard, tel, inTime, outTime, liveDays, price));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return historyList;
		
	}

	@Override
	public ArrayList<HistoryOrder> getHistoryOrderByName(String name, int off, int count) {
		ArrayList<HistoryOrder> historyList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status>3 and username=? limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				int orderNum = resultSet.getInt("order_number");
				int roomNum = resultSet.getInt("room_number");
				int roomType = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				int tel = resultSet.getInt("tel");
				int liveDays = resultSet.getInt("live_days");
				int idCard = resultSet.getInt("idcard");
				Date checkInTime = resultSet.getDate("checkin_time");
				Date checkOutTime = resultSet.getDate("checkout_time");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String inTime = sdf.format(checkInTime);
				String outTime = sdf.format(checkOutTime);
				//将信息封装为order对象
				historyList.add(new HistoryOrder(orderNum, roomNum, roomType, username, idCard, tel, inTime, outTime, liveDays, price));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return historyList;
		
	}

	@Override
	public ArrayList<HistoryOrder> getHistoryByroomNum(int roomNum, int off, int count) {
		ArrayList<HistoryOrder> historyList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status>3 and room_number=? limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, roomNum);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				int orderNum = resultSet.getInt("order_number");
				roomNum = resultSet.getInt("room_number");
				int roomType = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				int tel = resultSet.getInt("tel");
				int liveDays = resultSet.getInt("live_days");
				int idCard = resultSet.getInt("idcard");
				Date checkInTime = resultSet.getDate("checkin_time");
				Date checkOutTime = resultSet.getDate("checkout_time");


				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String inTime = sdf.format(checkInTime);
				String outTime = sdf.format(checkOutTime);
				//将信息封装为order对象
				historyList.add(new HistoryOrder(orderNum, roomNum, roomType, username, idCard, tel, inTime, outTime, liveDays, price));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return historyList;
		
	}

	@Override
	public ArrayList<HistoryOrder> getHistoryByOrderNum(String orderNum, int off, int count) {
		// TODO Auto-generated method stub
		ArrayList<HistoryOrder> historyList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status>3 and order_number=? limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, orderNum);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				orderNum = resultSet.getString("order_number");
				int roomNum = resultSet.getInt("room_number");
				int roomType = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				int tel = resultSet.getInt("tel");
				int liveDays = resultSet.getInt("live_days");
				int idCard = resultSet.getInt("idcard");
				Date checkInTime = resultSet.getDate("checkin_time");
				Date checkOutTime = resultSet.getDate("checkout_time");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String inTime = sdf.format(checkInTime);
				String outTime = sdf.format(checkOutTime);
				//将信息封装为order对象
				historyList.add(new HistoryOrder(Integer.parseInt(orderNum), roomNum, roomType, username, idCard, tel, inTime, outTime, liveDays, price));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return historyList;
	}

}
