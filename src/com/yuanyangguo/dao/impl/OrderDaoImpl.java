package com.yuanyangguo.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import com.yuanyangguo.dao.IOrderDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.Order;





public class OrderDaoImpl implements IOrderDao {

	@Override
	public void add(String username , String tel ,int status , int roomType,double price , 
			int roomNum , Date checkInTime , Date checkOutTime , String mail ) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		//根据时间加上10-100之间的随机数生成订单号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMmmss");
		String str = sdf.format(new java.util.Date());
		int orderNum = Integer.valueOf(str);
		System.out.println(orderNum);

		java.util.Date utilDate = new java.util.Date();
		long datems  = utilDate.getTime();
		java.sql.Date  sqlDate = new java.sql.Date(datems);
		
		//根据入住时间及离店时间计算出live_days
		
		
		int liveDays =  (int) (checkOutTime.getTime() - checkInTime.getTime())/(1000*60*60*24);

		
		String sql = "insert into order_list(username,tel,status,order_time,room_type,price,order_number,room_number,live_days,checkin_time,checkout_time,mail) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, tel);
			statement.setInt(3, status);
			statement.setDate(4, sqlDate);
			statement.setInt(5, roomType);
			statement.setDouble(6, price);
			statement.setInt(7,orderNum);
			statement.setInt(8, roomNum);
			statement.setInt(9, liveDays);
			statement.setDate(10, checkInTime);
			statement.setDate(11, checkOutTime);
			statement.setString(12, mail);
//			statement.setInt(13, idCard);//身份证号码
			statement.executeUpdate();
			conn.commit();//提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, null);
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
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrderList(int off, int count) {
		
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, off);
			statement.setInt(2, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				int status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——状态
	public ArrayList<Order> getOrderListByStatus(int off, int count, int status) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status=? limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		
		return orderList;
	}

	@Override
	//筛选条件——时间
	public ArrayList<Order> getOrderListByTime(int off, int count, int queryTime) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		switch(queryTime){
		//获取当前时间对象
		case 1://今日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)=0 LIMIT ?,?";
			break;
		case 2://近三日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<3 LIMIT ?,?";
			break;
		case 3://近一月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<30 LIMIT ?,?";
			break;
		case 4://近三月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<90 LIMIT ?,?";
			break;
		}
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setInt(1, off);
			statement.setInt(2, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				int status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——价格
	public ArrayList<Order> getOrderListByPrice(int off, int count, int priceMin, int priceMax) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where price>? and price<?  limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, priceMin);
			statement.setInt(2, priceMax);
			statement.setInt(3, off);
			statement.setInt(4, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				int status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——状态、时间
	public ArrayList<Order> getOrderListByStatusAndTime(int off, int count, int status, int queryTime) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		switch(queryTime){
		//获取当前时间对象
		case 1://今日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)=0 AND status=? LIMIT ?,?";
			break;
		case 2://近三日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=3 AND status=? LIMIT ?,?";
			break;
		case 3://近一月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=30 AND status=? LIMIT ?,?";
			break;
		case 4://近三月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=90 AND status=? LIMIT ?,?";
			break;
		}
		
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——状态、价格
	public ArrayList<Order> getOrderListByStatusAndPrice(int off, int count, int status, int priceMin, int priceMax) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn.setAutoCommit(false);//开启事务
			String sql = "select * from order_list where status=? and price>? and price<? limit ?,?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, priceMin);
			statement.setInt(3, priceMax);
			statement.setInt(4, off);
			statement.setInt(5, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——价格、时间
	public ArrayList<Order> getOrderListByPriceAndTime(int off, int count, int priceMin, int priceMax, int queryTime) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		switch(queryTime){
		case 1://今日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)=0 AND price>? AND price<? LIMIT ?,?";
			break;
		case 2://近三日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=3 AND price>? AND price<? LIMIT ?,?";
			break;
		case 3://近一月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=30 AND price>? AND price<? LIMIT ?,?";
			break;
		case 4://近三月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=90 AND price>? AND price<? LIMIT ?,?";
			break;
		}
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setInt(1, priceMin);
			statement.setInt(2, priceMax);
			statement.setInt(3, off);
			statement.setInt(4, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				int status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
				
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	//筛选条件——状态、价格、时间
	public ArrayList<Order> getOrderListByAll(int off, int count, int priceMin, int priceMax, int status,
			int queryTime) {
		ArrayList<Order> orderList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = null;
		switch(queryTime){
		case 1://今日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)=0 AND price>? AND price<? AND status=? LIMIT ?,?";
			break;
		case 2://近三日
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=3 AND price>? AND price<? AND status=? LIMIT ?,?";
			break;
		case 3://近一月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=30 AND price>? AND price<? AND status=? LIMIT ?,?";
			break;
		case 4://近三月
			sql = "SELECT * FROM order_list WHERE TO_DAYS(NOW()) - TO_DAYS(order_time)<=90 AND price>? AND price<? AND status=? LIMIT ?,?";
			break;
		}
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setInt(1, priceMin);
			statement.setInt(2, priceMax);
			statement.setInt(3, status);
			statement.setInt(4, off);
			statement.setInt(5, count);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				String tel = resultSet.getString("tel");
				status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				orderList.add(new Order(oTime, type, price, username, tel, status));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return orderList;
	}

	@Override
	public int getTotleOfOrder() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int total = 0;

		String sql = "SELECT * FROM order_list";
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				total++;
			}

		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return total;
	}

	@Override
	public int getTotleOfHistory() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int total = 0;

		String sql = "SELECT * FROM order_list WHERE status>3";
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				total++;
			}

		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return total;
	}

	@Override
	public Order getOrder(String tel, Date checkInTime, Date checkOutTime) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Order order = null;
		String sql = "SELECT * FROM order_list WHERE tel=? AND checkin_time=? AND checkout_time=?";
		try {
			conn.setAutoCommit(false);//开启事务
			statement = conn.prepareStatement(sql);
			statement.setString(1, tel);
			statement.setDate(2, checkInTime);
			statement.setDate(3, checkOutTime);
			resultSet = statement.executeQuery();
			conn.commit();//提交事务
			while(resultSet.next()){
				//获取每一个order对象信息
				Date orderTime = resultSet.getDate("order_time");
				int type = resultSet.getInt("room_type");
				double price = resultSet.getDouble("price");
				String username = resultSet.getString("username");
				tel = resultSet.getString("tel");
				int status = resultSet.getInt("status");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String oTime = sdf.format(orderTime);

				//将信息封装为order对象
				order = new Order(oTime, type, price, username, tel, status);
			}

		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return order;
	}
}
