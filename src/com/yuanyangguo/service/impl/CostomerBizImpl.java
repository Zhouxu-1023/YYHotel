package com.yuanyangguo.service.impl;

import com.yuanyangguo.dao.CostomerDao;
import com.yuanyangguo.dao.impl.CostomerDaoImpl;
import com.yuanyangguo.service.CostomerBiz;
import com.yuanyangguo.vo.Costomer;

public class CostomerBizImpl implements CostomerBiz{

	private CostomerDao costomerDao = new CostomerDaoImpl();
	private Costomer costomer;
	
	@Override
	public Costomer getCostomerByEmail(String email) {
		costomer=costomerDao.getCostomerByEmail(email);
		if(costomer!=null){//该邮箱已被注册，
			return costomer;
		}
 		return null;
	}

	@Override
	public int add(String sex, String surname, String name, String birthday, String email, String password,String address,
			String phone_number) {
		int result = -1;
 		result = costomerDao.add(sex, surname, name, birthday, email, password,address, phone_number);
 		return result;
	}

	@Override
	public Costomer getCostomerByEmail_password(String email, String password) {
		costomer = costomerDao.getCostomerByEmail_password(email, password);
 		if(costomer!=null){//登陆成功
			return costomer;
		}
 		return null;//登陆失败
	}

	
}
