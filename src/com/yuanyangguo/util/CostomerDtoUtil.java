package com.yuanyangguo.util;

import com.yuanyangguo.vo.Costomer;
import com.yuanyangguo.vo.CostomerDto;

public class CostomerDtoUtil {

	//登陆查询，返回costomer对象和islogin
	public static CostomerDto getLogin(Costomer costomer,boolean bool){
		CostomerDto costomerDto = new CostomerDto(costomer, bool);
		return costomerDto;
	} 
	
	
	
}
