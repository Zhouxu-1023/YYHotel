package com.yuanyangguo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yuanyangguo.dao.IRoomDao;
import com.yuanyangguo.util.DBUtil;
import com.yuanyangguo.vo.Room;

public class RoomDaoImpl implements IRoomDao {

	// 通过楼层查询
	@Override
	public ArrayList<Room> getRoomListByFloor(int floor, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where floor = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, floor);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过房间类型查询
	@Override
	public ArrayList<Room> getRoomListByType(int room_type, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where room_type = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, room_type);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过房间状态查询
	@Override
	public ArrayList<Room> getRoomListByStatus(int status, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where status = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, off);
			statement.setInt(3, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 全部
	@Override
	public ArrayList<Room> getRoomList(int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, off);
			statement.setInt(1, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过楼层和房间类型
	@Override
	public ArrayList<Room> getRoomListByFloorAndType(int floor, int room_type, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where floor = ? and room_type = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, floor);
			statement.setInt(2, room_type);
			statement.setInt(3, off);
			statement.setInt(4, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过楼层和状态
	@Override
	public ArrayList<Room> getRoomListByFloorAndStatus(int floor, int status, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where floor = ? and status = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, floor);
			statement.setInt(2, status);
			statement.setInt(3, off);
			statement.setInt(4, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				status = resultSet.getInt("status");
				floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过类型和状态
	@Override
	public ArrayList<Room> getRoomListByTypeAndStatus(int room_type, int status, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where room_type = ? and status = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, room_type);
			statement.setInt(2, status);
			statement.setInt(3, off);
			statement.setInt(4, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	// 通过楼层，类型和状态
	@Override
	public ArrayList<Room> getRoomListByAll(int floor, int room_type, int status, int off, int count) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where floor = ? and room_type = ? and status = ? limit ?,?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, floor);
			statement.setInt(2, room_type);
			statement.setInt(3, status);
			statement.setInt(4, off);
			statement.setInt(5, count);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				status = resultSet.getInt("status");
				floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");

				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	@Override
	public int getRoomSum() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select count(room_id) from room";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int sum = resultSet.getInt(1);
				return sum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return 0;
	}

	@Override
	public Room getRoom(int room_number) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from room where room_number";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int room_id = resultSet.getInt("room_id");
				room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");
				Room room = new Room(room_id, room_number, hotel_id, price, room_type, room_area, room_intro, status, floor,
						bed, window, recommend, clean, fix);
				return room;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return null;

	}

	@Override
	public ArrayList<Room> getRecommendRoom(int hotelId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		//此处不考虑房间是否可入住，只考虑是否推荐
		String sqlStr = "select * from room where recommend=1 and hotel_id=?";
		ArrayList<Room> roomList = new ArrayList<>();
		try {
			statement = conn.prepareStatement(sqlStr);
			statement.setInt(1, hotelId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int roomId = resultSet.getInt("room_id");
				int roomNumber = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int roomType = resultSet.getInt("room_type");
				int roomArea = resultSet.getInt("room_area");
				String roomIntro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");
				Room room = new Room(roomId, roomNumber, hotel_id, price, roomType, roomArea, roomIntro, status, floor,
						bed, window, recommend, clean, fix);
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return roomList;
	}

	@Override
	public int getRecoAmount(int hotelId, int roomType) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		//统计数量时考虑房间是否可入住，即返回可入住的推荐房间数量
		String sqlStr = "select count(room_id) from room where recommend=1 and hotel_id=? and room_type=? and status=1";
		try {
			statement = conn.prepareStatement(sqlStr);
			statement.setInt(1, hotelId);
			statement.setInt(2, roomType);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int amount = resultSet.getInt(1);
				return amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return 0;
	}

	@Override
	public int getAmount(int hotelId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sqlStr = "select count(room_id) from room where hotel_id=?";
		try {
			statement = conn.prepareStatement(sqlStr);
			statement.setInt(1, hotelId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int amount = resultSet.getInt(1);
				return amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return 0;
	}

	@Override
	public int getAmountByStatus(int hotelId, int status) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sqlStr = "select count(room_id) from room where hotel_id=? and status=?";
		try {
			statement = conn.prepareStatement(sqlStr);
			statement.setInt(1, hotelId);
			statement.setInt(2, status);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int amount = resultSet.getInt(1);
				return amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return 0;
	}

	@Override
	public Room getRoomByRoomNumber(int room_number) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from room where room_number = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, room_number);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				int room_id = resultSet.getInt("room_id");
				room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				int room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int  clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");
				Room room = new Room(room_id, room_number,hotel_id, price, room_type, room_area, room_intro, status, floor, bed, window, recommend, clean, fix);
				return room;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}
		return null;
	}

	@Override
	public ArrayList<Room> getRoomListByRoomType(int room_type) {
		ArrayList<Room> roomList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from room where room_type = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, room_type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int room_id = resultSet.getInt("room_id");
				int room_number = resultSet.getInt("room_number");
				int hotel_id = resultSet.getInt("hotel_id");
				double price = resultSet.getDouble("price");
				room_type = resultSet.getInt("room_type");
				int room_area = resultSet.getInt("room_area");
				String room_intro = resultSet.getString("room_intro");
				int status = resultSet.getInt("status");
				int floor = resultSet.getInt("floor");
				int bed = resultSet.getInt("bed");
				int window = resultSet.getInt("window");
				int recommend = resultSet.getInt("recommend");
				int  clean = resultSet.getInt("clean");
				int fix = resultSet.getInt("fix");
				
				
				Room room = new Room(room_id, room_number,hotel_id, price, room_type, room_area, room_intro, status, floor, bed, window, recommend, clean, fix);
				roomList.add(room);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, resultSet);
		}		
		return roomList;
	}

	@Override
	//修改指定房间的状态
	public void setStatus(int status ,int roomNum) {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE room SET status=? WHERE room_number = ?";
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, status);
			statement.setInt(2, roomNum);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, statement, null);
		}		
	}
}
