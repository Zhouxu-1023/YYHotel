package com.yuanyangguo.service.impl;
import com.yuanyangguo.dao.IAdminDao;
import com.yuanyangguo.dao.impl.AdminDaoImpl;
import com.yuanyangguo.service.IAmdinBiz;
import com.yuanyangguo.vo.Admin;

public class AmdinBizImpl implements IAmdinBiz{
	    private IAdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin getAdmin(String username) {
		
		return adminDao.getAdmin(username);
	}

	@Override
	public Admin getAdmin(String username, String password) {
		
		return adminDao.getAdmin(username, password);
	}

	@Override
	public void update(String username,String password,String name,String department,String duty,String phone,String wechat,String hiredate,String mail,String signature,String url) {
		adminDao.update( username, password, name, department, duty, phone, wechat, hiredate, mail,signature, url );
		
	}

	@Override
	public boolean isLogin(String username, String password) {
		Admin admin = adminDao.getAdmin(username, password);
		if (admin!=null) {
			return true;
		}
		return false;
	}

}
