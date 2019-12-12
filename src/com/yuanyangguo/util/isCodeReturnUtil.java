package com.yuanyangguo.util;

public class isCodeReturnUtil {

	//判断邮件验证码是否发送成功
	private boolean isCode;
	
	
	//邮件是否发送成功，注册是否成功构造	器
	public isCodeReturnUtil(boolean isCode) {
 		this.isCode = isCode;
 	}
	public boolean getIsCode() {
		return isCode;
	}
	public void setCode(boolean isCode) {
		this.isCode = isCode;
	}
	
	
}
