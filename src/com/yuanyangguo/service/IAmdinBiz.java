package com.yuanyangguo.service;

import com.yuanyangguo.vo.Admin;

public interface IAmdinBiz {
	
    public Admin getAdmin(String username);
	
    //获取密码账户
	public Admin getAdmin(String username,String password);
	
	//更新Admin里面的数据
	public void update(String username,String password,String name,String department,String duty,String phone,String wechat,String hiredate,String mail,String signature,String url); 
	
	//判断是否可以登录
	public boolean isLogin(String username,String password);
	
}
