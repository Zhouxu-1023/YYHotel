package com.yuanyangguo.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuanyangguo.dao.IHotelDao;
import com.yuanyangguo.dao.impl.HotelDaoImpl;
import com.yuanyangguo.service.IHotelBiz;
import com.yuanyangguo.vo.Hotel;

public class HotelBiz implements IHotelBiz{

	private IHotelDao hotelDaoImpl = new HotelDaoImpl();
	
	@Override
	public String getHotelInformation() {
		Hotel hotelInformation = hotelDaoImpl.getHotelInformation();
		return JSON.toJSONString(hotelInformation);
	}

	@Override
	public String getHotelServices() {
		Hotel hotelServices = hotelDaoImpl.getHotelServices();
		return JSON.toJSONString(hotelServices);
	}

	@Override
	public String getHotelMoveInto() {
		Hotel hotelMoveInto = hotelDaoImpl.getHotelMoveInto();
		return JSON.toJSONString(hotelMoveInto);
	}

	@Override
	public String updateHotelInformation(String name, String province, String city, String area, String address, String phone, String diagram,
			String description, String enabled) {
		Hotel updateHotelInformation = hotelDaoImpl.updateHotelInformation(name, province, city, area, address, phone, diagram, description, enabled);
		return JSON.toJSONString(updateHotelInformation);
	}

	@Override
	public String updateHotelServices(String basic, String business, String hotel, String recreational,
			String repast) {
		Hotel updateHotelServices = hotelDaoImpl.updateHotelServices(basic, business, hotel, recreational, repast);
		return JSON.toJSONString(updateHotelServices);
	}

	@Override
	public String updateHotelMoveInto(String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
			String children, String food, String pet, String tips, String tipsValues) {
		Hotel updateHotelMoveInto = hotelDaoImpl.updateHotelMoveInto(moveinto, intoHour, intoMinutes, leaveHour, leaveMinutes, children, food, pet, tips, tipsValues);
		return JSON.toJSONString(updateHotelMoveInto);
	}

}
