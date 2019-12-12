package com.yuanyangguo.vo;
/**
 * 注意编码格式
 * @author zhuyifan
 *
 */
public class Room {
	private int roomId;
	private int roomNumber;
	private int hotelId;
	private double price;
	private int roomType;
	private int roomArea;
	private String roomIntro;
	private int status;
	private int floor;
	private int bed;
	private int window;
	private int recommend;
	private int clean;
	private int fix;

	public Room() {
	}

	public Room(int roomId, int roomNumber, int hotelId, double price, int roomType, int roomArea, String roomIntro,
			int status, int floor, int bed, int window, int recommend, int clean, int fix) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.hotelId = hotelId;
		this.price = price;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.roomIntro = roomIntro;
		this.status = status;
		this.floor = floor;
		this.bed = bed;
		this.window = window;
		this.recommend = recommend;
		this.clean = clean;
		this.fix = fix;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(int roomArea) {
		this.roomArea = roomArea;
	}

	public String getRoomIntro() {
		return roomIntro;
	}

	public void setRoomIntro(String roomIntro) {
		this.roomIntro = roomIntro;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}

	public int getFix() {
		return fix;
	}

	public void setFix(int fix) {
		this.fix = fix;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", hotelId=" + hotelId + ", price=" + price
				+ ", roomType=" + roomType + ", roomArea=" + roomArea + ", roomIntro=" + roomIntro + ", status="
				+ status + ", floor=" + floor + ", bed=" + bed + ", window=" + window + ", recommend=" + recommend
				+ ", clean=" + clean + ", fix=" + fix + "]";
	}

}
