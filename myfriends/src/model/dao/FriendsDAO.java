package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.Friends;

public class FriendsDAO {
	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;
	
	public FriendsDAO() {
		connectDB = new ConnectDBLibrary();
	}
	
	public ArrayList<Friends> getAll() {
		ArrayList<Friends> listFriend = new ArrayList<>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM friends ORDER BY fid DESC";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friends objFriend = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview_text"), rs.getString("detail"), rs.getTimestamp("date_create"), rs.getInt("fl_id"), rs.getInt("count_number"), rs.getString("picture"));
				listFriend.add(objFriend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return listFriend;
	}
	
	public ArrayList<Friends> findByCatId(int listId){
		ArrayList<Friends> listFriend = new ArrayList<Friends>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM friends WHERE fl_id = " + listId + " LIMIT 2";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friends objFriend = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview_text"), rs.getString("detail"), rs.getTimestamp("date_create"), rs.getInt("fl_id"), rs.getInt("count_number"), rs.getString("picture"));
				listFriend.add(objFriend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}
		return listFriend;
	}
	
	public Friends findById(int id) {
		Friends objFriend = null;
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM friends WHERE fid = " + id ;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				objFriend = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview_text"), rs.getString("detail"), rs.getTimestamp("date_create"), rs.getInt("fl_id"), rs.getInt("count_number"), rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectDB.close(con, st, rs);
		}
		
		return objFriend;
	}
}
