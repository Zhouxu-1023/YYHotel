package com.yuanyangguo.dao;

import com.yuanyangguo.vo.Hotel;

public interface IHotelDao {
	public Hotel getHotelInformation();
    
    public Hotel getHotelServices();
    
    public Hotel getHotelMoveInto();
    
    public Hotel updateHotelInformation(String name, String province, String city, String area, String address, String phone, String diagram,
			String description, String enabled);
    
    public Hotel updateHotelServices(String basic, String business, String hotel, String recreational,
			String repast);
    
    public Hotel updateHotelMoveInto(String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
			String children, String food, String pet, String tips, String tipsValues);
}
