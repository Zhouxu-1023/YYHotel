package com.yuanyangguo.dao;

import com.yuanyangguo.vo.Admin;

public interface IAdminDao {
	
	public Admin getAdmin(String username);
	
	//查询密码账户
	public Admin getAdmin(String username,String password);
	
	//更新Admin里面的数据
	public void  update(String username,String password,String name,String department,String duty,String phone,String wechat,String hiredate,String mail,String signature,String url );

}
