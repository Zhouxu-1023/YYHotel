package com.yuanyangguo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanyangguo.service.IHotelBiz;
import com.yuanyangguo.service.impl.HotelBiz;

public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHotelBiz hotelBiz = new HotelBiz();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String diagram = request.getParameter("diagram");
		String description = request.getParameter("description");
		String enabled = request.getParameter("enabled");
		String basic = request.getParameter("basic");
		String business = request.getParameter("business");
		String hotel = request.getParameter("hotel");
		String recreational = request.getParameter("recreational");
		String repast = request.getParameter("repast");
		String moveinto = request.getParameter("moveinto");
		String intoHour = request.getParameter("intoHour");
		String intoMinutes = request.getParameter("intoMinutes");
		String leaveHour = request.getParameter("leaveHour");
		String leaveMinutes = request.getParameter("leaveMinutes");
		String children = request.getParameter("children");
		String food = request.getParameter("food");
		String pet = request.getParameter("pet");
		String tips = request.getParameter("tips");
		String tipsValues = request.getParameter("tipsValues");
		
		if ("BasicInformation".equals(action)) {
			String basicInformation = hotelBiz.getHotelInformation();
			response.getWriter().println(basicInformation);
		}else if ("FacilitiesServices".equals(action)) {
			String facilitiesServices = hotelBiz.getHotelServices();
			response.getWriter().println(facilitiesServices);
		}else if ("StayNotice".equals(action)) {
			String stayNotice = hotelBiz.getHotelMoveInto();
			response.getWriter().println(stayNotice);
		}else if ("BasicInformationModify".equals(action)) {
			String basicInformationModify =hotelBiz.updateHotelInformation(name, province, city, area, address, phone, diagram, description, enabled);
			response.getWriter().println(basicInformationModify);
		}else if ("FacilitiesServicesModify".equals(action)) {
			String facilitiesServicesModify =hotelBiz.updateHotelServices(basic, business, hotel, recreational, repast);
			response.getWriter().println(facilitiesServicesModify);
		}else if ("StayNoticeModify".equals(action)) {
			String stayNoticeModify =hotelBiz.updateHotelMoveInto(moveinto, intoHour, intoMinutes, leaveHour, leaveMinutes, children, food, pet, tips, tipsValues);
			response.getWriter().println(stayNoticeModify);
		}
		
	}

}
