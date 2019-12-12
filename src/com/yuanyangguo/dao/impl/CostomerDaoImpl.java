package com.yuanyangguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuanyangguo.dao.CostomerDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.Costomer;

public class CostomerDaoImpl implements CostomerDao{
	private Costomer costomer;
	@Override
	public Costomer getCostomerByEmail(String email) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement p = null;
		ResultSet res = null;
		String sql="select * from costomer where email=?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, email);
			res = p.executeQuery();
			if(res.next()){
				int id = res.getInt("id");
				String sex = res.getString("sex");
				String surname = res.getString("surname");
				String name = res.getString("name");
				String birthday = res.getString("birthday");
				email = res.getString("email");
				String password = res.getString("password");
				String address = res.getString("address");
				String phone_number = res.getString("phone_number"); 
				costomer = new Costomer(id, sex, surname, name, birthday, email, password, address, phone_number);
				return costomer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, p, res);
		}
		
 		return null;
	}
	
	@Override
	public int add(String sex, String surname, String name, String birthday, String email, String password,String address,
			String phone_number) {
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement p = null;
		int result = -1;
 		String sql="insert into costomer(sex,surname,name,birthday,email,password,address,phone_number)values(?,?,?,?,?,?,?,?)";
		try {
			p = conn.prepareStatement(sql);
  			p.setString(1, sex);
  			p.setString(2, surname);
  			p.setString(3, name);
  			p.setString(4, birthday);
  			p.setString(5, email);
  			p.setString(6, password);
  			p.setString(7, address);
  			p.setString(8, phone_number);
  			result = p.executeUpdate();
  			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, p, null);
		}
		return result;		
	}

	@Override
	public Costomer getCostomerByEmail_password(String email, String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement p = null;
		ResultSet res = null;
		String sql="select * from costomer where email=? and password=?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, email);
			p.setString(2, password);
			res = p.executeQuery();
			if(res.next()){
				int id = res.getInt("id");
				String sex = res.getString("sex");
				String surname = res.getString("surname");
				String name = res.getString("name");
				String birthday = res.getString("birthday");
				email = res.getString("email");
				password = res.getString("password");
				String address = res.getString("address");
				String phone_number = res.getString("phone_number"); 
				costomer = new Costomer(id, sex, surname, name, birthday, email, password, address, phone_number);
				return costomer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, p, res);
		}
		
 		return null;
	}

}
