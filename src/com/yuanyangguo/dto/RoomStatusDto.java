package com.yuanyangguo.dto;

/**
 * 酒店房间状态Dto 各类型房间数量及所占比例
 * 
 * @author zhuyifan
 *
 */
public class RoomStatusDto {
	private int emptyRoom;
	private double emptyRate;
	private int busyRoom;
	private double busyRate;
	private int cleanRoom;
	private double cleanRate;
	private int fixRoom;
	private double fixRate;

	public RoomStatusDto() {
	}

	public RoomStatusDto(int emptyRoom, double emptyRate, int busyRoom, double busyRate, int cleanRoom,
			double cleanRate, int fixRoom, double fixRate) {
		this.emptyRoom = emptyRoom;
		this.emptyRate = emptyRate;
		this.busyRoom = busyRoom;
		this.busyRate = busyRate;
		this.cleanRoom = cleanRoom;
		this.cleanRate = cleanRate;
		this.fixRoom = fixRoom;
		this.fixRate = fixRate;
	}

	public int getEmptyRoom() {
		return emptyRoom;
	}

	public void setEmptyRoom(int emptyRoom) {
		this.emptyRoom = emptyRoom;
	}

	public double getEmptyRate() {
		return emptyRate;
	}

	public void setEmptyRate(double emptyRate) {
		this.emptyRate = emptyRate;
	}

	public int getBusyRoom() {
		return busyRoom;
	}

	public void setBusyRoom(int busyRoom) {
		this.busyRoom = busyRoom;
	}

	public double getBusyRate() {
		return busyRate;
	}

	public void setBusyRate(double busyRate) {
		this.busyRate = busyRate;
	}

	public int getCleanRoom() {
		return cleanRoom;
	}

	public void setCleanRoom(int cleanRoom) {
		this.cleanRoom = cleanRoom;
	}

	public double getCleanRate() {
		return cleanRate;
	}

	public void setCleanRate(double cleanRate) {
		this.cleanRate = cleanRate;
	}

	public int getFixRoom() {
		return fixRoom;
	}

	public void setFixRoom(int fixRoom) {
		this.fixRoom = fixRoom;
	}

	public double getFixRate() {
		return fixRate;
	}

	public void setFixRate(double fixRate) {
		this.fixRate = fixRate;
	}

	@Override
	public String toString() {
		return "RoomStatusDto [emptyRoom=" + emptyRoom + ", emptyRate=" + emptyRate + ", busyRoom=" + busyRoom
				+ ", busyRate=" + busyRate + ", cleanRoom=" + cleanRoom + ", cleanRate=" + cleanRate + ", fixRoom="
				+ fixRoom + ", fixRate=" + fixRate + "]";
	}
}
