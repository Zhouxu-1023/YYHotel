package com.yuanyangguo.service;

import com.yuanyangguo.vo.Hotel;

public interface IHotelBiz {
       public String getHotelInformation();
       
       public String getHotelServices();
       
       public String getHotelMoveInto();
       
       public String updateHotelInformation(String name, String province, String city, String area, String address, String phone, String diagram,
   			String description, String enabled);
       
       public String updateHotelServices(String basic, String business, String hotel, String recreational,
   			String repast);
       
       public String updateHotelMoveInto(String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
   			String children, String food, String pet, String tips, String tipsValues);
}
