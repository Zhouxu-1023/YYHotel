package com.yuanyangguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.bind.v2.runtime.Name;
import com.yuanyangguo.dao.IHotelDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.Hotel;

public class HotelDaoImpl implements IHotelDao{

	@Override
	public Hotel getHotelInformation() {
		Connection connection = DBUtil.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String sql = "select * from hotel_basic_information";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("hotel_name");
				String province = resultSet.getString("hotel_address_province");
				String city = resultSet.getString("hotel_address_city");
				String area = resultSet.getString("hotel_address_area");
				String address = resultSet.getString("hotel_detailed_address");
				String phone = resultSet.getString("hotel_phone");
				String diagram = resultSet.getString("main_diagram");
				String description = resultSet.getString("hotel_location_description");
				String enabled = resultSet.getString("enabled");
				return new Hotel(name,province,city,area,address,phone,diagram,description,enabled);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	@Override
	public Hotel getHotelServices() {
		Connection connection = DBUtil.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String sql = "select * from facilities_services";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String basic = resultSet.getString("basic_facilities");
				String business = resultSet.getString("business_facilities");
				String hotel = resultSet.getString("hotel_facilities");
				String recreational = resultSet.getString("recreational_facilities");
				String repast = resultSet.getString("fb_serve");
				return new Hotel(basic,business,hotel,recreational,repast);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	@Override
	public Hotel getHotelMoveInto() {
		Connection connection = DBUtil.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String sql = "select * from stay_notice";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String moveinto = resultSet.getString("hotel_moveinto");
				String intoHour = resultSet.getString("into_time_hour");
				String intoMinutes = resultSet.getString("into_time_minutes");
				String leaveHour = resultSet.getString("leave_time_hour");
				String leaveMinutes = resultSet.getString("leave_time_minutes");
				String children = resultSet.getString("children_policy");
				String food = resultSet.getString("food_arrange");
				String pet = resultSet.getString("pet_policy");
				String tips = resultSet.getString("hotel_tips");
				String tipsValues = resultSet.getString("hotel_tips_values");
				return new Hotel(moveinto,intoHour,intoMinutes,leaveHour,leaveMinutes,children,food,pet,tips,tipsValues);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	@Override
	public Hotel updateHotelInformation(String name, String province, String city, String area, String address, String phone, String diagram,
			String description, String enabled) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update hotel_basic_information set hotel_name=?,"
				+ "hotel_address_province=?,"
				+ "hotel_address_city=?,"
				+ "hotel_address_area=?,"
				+ "hotel_detailed_address=?,"
				+ "hotel_phone=?,"
				+ "main_diagram=?,"
				+ "hotel_location_description=?,"
				+ "enabled=? "
				+ "where id=1";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, province);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, area);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, phone);
			preparedStatement.setString(7, diagram);
			preparedStatement.setString(8, description);
			preparedStatement.setString(9, enabled);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, null);
		}
		return null;
	}

	@Override
	public Hotel updateHotelServices(String basic, String business, String hotel, String recreational,
			String repast) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update facilities_services set basic_facilities=?,"
				+ "business_facilities=?,"
				+ "hotel_facilities=?,"
				+ "recreational_facilities=?,"
				+ "fb_serve=? "
				+ "where id=1";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, basic);
			preparedStatement.setString(2, business);
			preparedStatement.setString(3, hotel);
			preparedStatement.setString(4, recreational);
			preparedStatement.setString(5, repast);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, null);
		}
		return null;
	}

	@Override
	public Hotel updateHotelMoveInto(String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
			String children, String food, String pet, String tips, String tipsValues) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update stay_notice set hotel_moveinto=?"
				+ "into_time_hour"
				+ "into_time_minutes"
				+ "leave_time_hour"
				+ "leave_time_minutes"
				+ "children_policy"
				+ "food_arrange"
				+ "pet_policy"
				+ "hotel_tips"
				+ "hotel_tips_values "
				+ "where id=1";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, moveinto);
			preparedStatement.setString(2, intoHour);
			preparedStatement.setString(3, intoMinutes);
			preparedStatement.setString(4, leaveHour);
			preparedStatement.setString(5, leaveMinutes);
			preparedStatement.setString(6, children);
			preparedStatement.setString(7, food);
			preparedStatement.setString(8, pet);
			preparedStatement.setString(9, tips);
			preparedStatement.setString(10,tipsValues);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, preparedStatement, null);
		}
		return null;
	}

}
