package com.yuanyangguo.dto;

public class PicDto {
	private int id;
	private String imgUrl;

	public PicDto() {
		// TODO Auto-generated constructor stub
	}

	public PicDto(int id, String imgUrl) {
		this.id = id;
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "PicDto [id=" + id + ", imgUrl=" + imgUrl + "]";
	}
}
