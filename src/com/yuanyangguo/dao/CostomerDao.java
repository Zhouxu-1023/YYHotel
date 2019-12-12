package com.yuanyangguo.dao;

import com.yuanyangguo.vo.Costomer;

public interface CostomerDao {

	public Costomer getCostomerByEmail(String email);
	
	public Costomer getCostomerByEmail_password(String email,String password);
	
	public int add(String sex, String surname, String name, String birthday, String email, String password,String address,String phone_number);
	
}
