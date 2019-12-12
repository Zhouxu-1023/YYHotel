package com.yuanyangguo.util;

public class StringUtil {
	
	public static String getStr(String[] ss) {
		StringBuilder sb = new StringBuilder();
		for (String string : ss) {
			sb.append(string);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public static String[] getArray(String str) {
		String[] split = str.split(",");
		return split;
	}

}
