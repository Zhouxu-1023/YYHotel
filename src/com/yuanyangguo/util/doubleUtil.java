package com.yuanyangguo.util;

import java.math.BigDecimal;

public class doubleUtil {
	public static double getDouble(double doubleVar, int digits) {
		if (digits <= 0) {
			return 0;
		}
		BigDecimal doubleNum = new BigDecimal(doubleVar);
		double resultNum = doubleNum.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
		return resultNum;
	}
}
