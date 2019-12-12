package com.yuanyangguo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dto.BannerImgDto;
import com.yuanyangguo.dto.ResultDto;
import com.yuanyangguo.service.IPicBiz;
import com.yuanyangguo.service.impl.PicBizImpl;

public class PicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPicBiz picBiz = new PicBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if (action.equals("homePage")) {
			//把照片List放入bannerImgDto对象中
			BannerImgDto bannerImgDto = new BannerImgDto(picBiz.getHomePagePic());
			//把bannerImgDto对象放入ResultDto中
			ResultDto resultDto = new ResultDto(0, bannerImgDto);
			//按照前端要求的格式返回
			response.getWriter().println(JSON.toJSONString(resultDto));
		}
	}

}
