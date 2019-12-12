package com.yuanyangguo.vo;

public class Hotel {
	
	String name ;
	String province ;
	String city ;
	String area ;
	String address ;
	String phone ;
	String diagram ;
	String description ;
	String enabled ;
	String basic ;
	String business ;
	String hotel ;
	String recreational ;
	String repast ;
	String moveinto ;
	String intoHour ;
	String intoMinutes ;
	String leaveHour ;
	String leaveMinutes ;
	String children ;
	String food ;
	String pet ;
	String tips ;
	String tipsValues ;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	
	public Hotel(String name, String province, String city, String area, String address, String phone, String diagram,
			String description, String enabled) {
		this.name = name;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.phone = phone;
		this.diagram = diagram;
		this.description = description;
		this.enabled = enabled;
	}
	
	public Hotel(String basic, String business, String hotel, String recreational,
			String repast) {
		this.basic = basic;
		this.business = business;
		this.hotel = hotel;
		this.recreational = recreational;
		this.repast = repast;
	}
	
	public Hotel(String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
			String children, String food, String pet, String tips, String tipsValues) {
		this.moveinto = moveinto;
		this.intoHour = intoHour;
		this.intoMinutes = intoMinutes;
		this.leaveHour = leaveHour;
		this.leaveMinutes = leaveMinutes;
		this.children = children;
		this.food = food;
		this.pet = pet;
		this.tips = tips;
		this.tipsValues = tipsValues;
	}

	public Hotel(String name, String province, String city, String area, String address, String phone, String diagram,
			String description, String enabled, String basic, String business, String hotel, String recreational,
			String repast, String moveinto, String intoHour, String intoMinutes, String leaveHour, String leaveMinutes,
			String children, String food, String pet, String tips, String tipsValues) {
		this.name = name;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.phone = phone;
		this.diagram = diagram;
		this.description = description;
		this.enabled = enabled;
		this.basic = basic;
		this.business = business;
		this.hotel = hotel;
		this.recreational = recreational;
		this.repast = repast;
		this.moveinto = moveinto;
		this.intoHour = intoHour;
		this.intoMinutes = intoMinutes;
		this.leaveHour = leaveHour;
		this.leaveMinutes = leaveMinutes;
		this.children = children;
		this.food = food;
		this.pet = pet;
		this.tips = tips;
		this.tipsValues = tipsValues;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiagram() {
		return diagram;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getRecreational() {
		return recreational;
	}

	public void setRecreational(String recreational) {
		this.recreational = recreational;
	}

	public String getRepast() {
		return repast;
	}

	public void setRepast(String repast) {
		this.repast = repast;
	}

	public String getMoveinto() {
		return moveinto;
	}

	public void setMoveinto(String moveinto) {
		this.moveinto = moveinto;
	}

	public String getIntoHour() {
		return intoHour;
	}

	public void setIntoHour(String intoHour) {
		this.intoHour = intoHour;
	}

	public String getIntoMinutes() {
		return intoMinutes;
	}

	public void setIntoMinutes(String intoMinutes) {
		this.intoMinutes = intoMinutes;
	}

	public String getLeaveHour() {
		return leaveHour;
	}

	public void setLeaveHour(String leaveHour) {
		this.leaveHour = leaveHour;
	}

	public String getLeaveMinutes() {
		return leaveMinutes;
	}

	public void setLeaveMinutes(String leaveMinutes) {
		this.leaveMinutes = leaveMinutes;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTipsValues() {
		return tipsValues;
	}

	public void setTipsValues(String tipsValues) {
		this.tipsValues = tipsValues;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", province=" + province + ", city=" + city + ", area=" + area + ", address="
				+ address + ", phone=" + phone + ", diagram=" + diagram + ", description=" + description + ", enabled="
				+ enabled + ", basic=" + basic + ", business=" + business + ", hotel=" + hotel + ", recreational="
				+ recreational + ", repast=" + repast + ", moveinto=" + moveinto + ", intoHour=" + intoHour
				+ ", intoMinutes=" + intoMinutes + ", leaveHour=" + leaveHour + ", leaveMinutes=" + leaveMinutes
				+ ", children=" + children + ", food=" + food + ", pet=" + pet + ", tips=" + tips + ", tipsValues="
				+ tipsValues + "]";
	}
	
	
}
