package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectDBLibrary;
import model.bean.Contact;

public class ContactDAO {
	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pst;

	public ContactDAO() {
		connectDB = new ConnectDBLibrary();
	}

	public int add(Contact objContact) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "INSERT INTO contact (name, email, phone, content) VALUE (?, ?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objContact.getName());
			pst.setString(2, objContact.getEmail());
			pst.setInt(3, objContact.getPhone());
			pst.setString(4, objContact.getContent());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, pst);
		}
		return result;
	}
}
