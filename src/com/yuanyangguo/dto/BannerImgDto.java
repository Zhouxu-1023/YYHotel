package com.yuanyangguo.dto;

public class BannerImgDto {
	private Object bannerImg;

	public BannerImgDto() {
	}

	public Object getBannerImg() {
		return bannerImg;
	}

	public void setBannerImg(Object bannerImg) {
		this.bannerImg = bannerImg;
	}

	public BannerImgDto(Object bannerImg) {
		super();
		this.bannerImg = bannerImg;
	}

	@Override
	public String toString() {
		return "BannerImgDto [bannerImg=" + bannerImg + "]";
	}
}
