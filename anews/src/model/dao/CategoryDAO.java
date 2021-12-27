package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.Category;

public class CategoryDAO {

	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pst;

	public CategoryDAO() {
		connectDB = new ConnectDBLibrary();
	}

	public ArrayList<Category> getAll() {
		ArrayList<Category> listCat = new ArrayList<>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM danhmuctin";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category objCat = new Category(rs.getInt("idDanhMucTin"), rs.getString("tenDanhMucTin"));
				listCat.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return listCat;
	}

	// Phương thức lấy danh mục tin theo id. Vì id là thuộc tính duy nhất nên phương
	// thức trả về 1 đối tượng

	public Category findById(int id) {
		Category objCat = null;
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM danhmuctin WHERE idDanhMucTin = " + id;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objCat = new Category(rs.getInt("idDanhMucTin"), rs.getString("tenDanhMucTin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return objCat;
	}

	public int add(Category objCat) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "INSERT INTO danhmuctin(tenDanhMucTin) VALUE (?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objCat.getCatName());
			result = pst.executeUpdate();// thanh cong: result > 0
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, pst);
		}

		return result;
	}

	public int update(Category category) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "UPDATE danhmuctin SET tenDanhMucTin = ? WHERE idDanhMucTin = ? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, category.getCatName());
			pst.setInt(2, category.getCatId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, pst);
		}
		return result;
	}

	public int delete(int id) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "DELETE FROM danhmuctin WHERE idDanhMucTin = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result  = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectDB.close(con, pst);
		}
		return result;
	}
	
	
}
