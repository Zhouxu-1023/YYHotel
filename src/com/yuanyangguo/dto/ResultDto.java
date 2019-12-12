package com.yuanyangguo.dto;

public class ResultDto {
	private int errorCode;
	private Object data;
	public ResultDto() {
	}
	public ResultDto(int errorCode, Object data) {
		this.errorCode = errorCode;
		this.data = data;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultDto [errorCode=" + errorCode + ", data=" + data + "]";
	}
	
}
