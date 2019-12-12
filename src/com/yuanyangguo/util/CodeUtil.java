package com.yuanyangguo.util;

 import java.util.Random;

public class CodeUtil {

	static String[] ts = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","0","1","2","3","4","5","6","7","8","9"};
	
	public static String getCode(){
		Random ran = new Random();
		String text = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
 			text = ts[ran.nextInt(ts.length)];//随机验证码
			sb.append(text);
		}
		//验证码
		String code = sb+"";
		return code;
	}
	
}
