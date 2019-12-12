package com.yuanyangguo.util;

import com.yuanyangguo.dto.AdminDto;
import com.yuanyangguo.vo.Admin;

public class AdminDtoUtil {
	
    public static AdminDto getAdminDto(Admin admin,boolean isLogin) {
    	AdminDto adminDto = new AdminDto();
    	adminDto.setAdmin(admin);
    	adminDto.setIsLogin(isLogin);
		return adminDto;
	}
}
