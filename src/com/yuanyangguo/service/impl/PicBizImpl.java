package com.yuanyangguo.service.impl;

import java.util.ArrayList;

import com.yuanyangguo.dto.PicDto;
import com.yuanyangguo.service.IPicBiz;

public class PicBizImpl implements IPicBiz {

	@Override
	public ArrayList<PicDto> getHomePagePic() {
		ArrayList<PicDto> picList = new ArrayList<>();
		picList.add(new PicDto(1, "http://120.55.43.219:8080/img/homePage/1.jpg"));
		picList.add(new PicDto(2, "http://120.55.43.219:8080/img/homePage/2.jpg"));
		picList.add(new PicDto(3, "http://120.55.43.219:8080/img/homePage/3.jpg"));
		picList.add(new PicDto(4, "http://120.55.43.219:8080/img/homePage/4.jpg"));

		return picList;
	}

}
