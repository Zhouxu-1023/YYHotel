package com.yuanyangguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuanyangguo.dao.IAdminDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.Admin;

public class AdminDaoImpl implements IAdminDao{

	@Override
	public Admin getAdmin(String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement =null;
		ResultSet resultSet = null;
		String sql="select * from admin where username=?";
		try {
			 statement = conn.prepareStatement(sql);
			 statement.setString(1, username);
			 resultSet = statement.executeQuery();
			 if (resultSet.next()) {
				resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String department = resultSet.getString("department");
				String duty = resultSet.getString("duty");
				String phone = resultSet.getString("phone");
				String wechat = resultSet.getString("wechat");
				String hiredate = resultSet.getString("hiredate");
				String mail = resultSet.getString("mail");
				String signature = resultSet.getString("signature");
				String url = resultSet.getString("url");
				return new Admin(username, password, name, department, duty, phone, wechat, hiredate, mail, signature,url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return null;
	}

	@Override
	public Admin getAdmin(String username, String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet =null;
		String sql="select * from admin where username=? and password=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 username = resultSet.getString("username");
				 password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String department = resultSet.getString("department");
				String duty = resultSet.getString("duty");
				String phone = resultSet.getString("phone");
				String wechat = resultSet.getString("wechat");
				String hiredate = resultSet.getString("hiredate");
				String mail = resultSet.getString("mail");
				String signature = resultSet.getString("signature");
				String url = resultSet.getString("url");
				return new Admin(username, password, name, department, duty, phone, wechat, hiredate, mail, signature,url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, resultSet);
			
		}
		return null;
	}

	@Override
	public void  update(String username,String password,String name,String department,String duty,String phone,String wechat,String hiredate,String mail,String signature,String url) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement =null;
		String sql="update admin set password=?,name=?,department=?,duty=?,phone=?,wechat=?,hiredate=?,mail=?,signature=?,url=? where username=?";
		try {
			 statement = conn.prepareStatement(sql);
			 statement.setString(1,password);
			 statement.setString(2,name);
			 statement.setString(3,department);
			 statement.setString(4,duty);
			 statement.setString(5,phone);
			 statement.setString(6,wechat);
			 statement.setString(7,hiredate);
			 statement.setString(8,mail);
			 statement.setString(9,signature);
			 statement.setString(10,url);
			 statement.setString(11,username);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, statement, null);
		}
	}

}
