package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.FriendsList;
public class FriendsListDAO {
	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;

	public FriendsListDAO() {
		connectDB = new ConnectDBLibrary();
	}

	public ArrayList<FriendsList> getAll() {
		ArrayList<FriendsList> listFriends = new ArrayList<>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM friend_list";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				FriendsList objFriends = new FriendsList(rs.getInt("fl_id"), rs.getString("flname"));
				listFriends.add(objFriends);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return listFriends;
	}
	
	//phương thức lấy danh sach ban be theo id
	public FriendsList findById(int id) {
		FriendsList objList = null;
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM friend_list WHERE fl_id = " + id;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				objList = new FriendsList(rs.getInt("fl_id"), rs.getString("flname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}
		
		return objList;
	}
}
