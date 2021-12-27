package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.News;

public class NewsDAO {
	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pst;

	public NewsDAO() {
		connectDB = new ConnectDBLibrary();
	}

	public ArrayList<News> getAll() {
		ArrayList<News> listNews = new ArrayList<>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM tintuc ORDER BY idTinTuc DESC";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				News objNews = new News(rs.getInt("idTinTuc"), rs.getString("tenTinTuc"), rs.getString("moTa"),
						rs.getString("chiTiet"), rs.getTimestamp("ngayDang"), rs.getInt("idDanhMucTin"));
				listNews.add(objNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return listNews;
	}

	// phương thức lấy danh sách tin theo danh mục tin(id danh mục tin).
	// Lấy tin tức theo danh mục tin sẽ truyền vào một tham số là catId
	// (idDanhMucTin)
	// thực hiện truy vấn và trả về kết quả
	public ArrayList<News> findByCatId(int catId) {
		ArrayList<News> listNews = new ArrayList<News>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM tintuc WHERE idDanhMucTin = ?";
		try {
			pst = con.prepareStatement(sql);
			// khi sử dụng prepareStatement ta cần truyền giá trị tham số trong câu lệnh sql
			// là catId
			pst.setInt(1, catId);
			rs = pst.executeQuery(sql);
			while (rs.next()) {
				News objNews = new News(rs.getInt("idTinTuc"), rs.getString("tenTinTuc"), rs.getString("moTa"),
						rs.getString("chiTiet"), rs.getTimestamp("ngayDang"), rs.getInt("idDanhMucTin"));
				listNews.add(objNews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}
		return listNews;
	}

	// phương thức lấy tin tức theo id
	public News findById(int id) {
		News objNews = null;
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM tintuc WHERE idTinTuc = " + id;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objNews = new News(rs.getInt("idTinTuc"), rs.getString("tenTinTuc"), rs.getString("moTa"),
						rs.getString("chiTiet"), rs.getTimestamp("ngayDang"), rs.getInt("idDanhMucTin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return objNews;
	}

	public int add(News objNews) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "INSERT INTO tintuc(tenTinTuc, moTa, chiTiet, idDanhMucTin) VALUE (?,?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objNews.getName());
			pst.setString(2, objNews.getDescription());
			pst.setString(3, objNews.getDetail());
			pst.setInt(4, objNews.getCatId());
			result = pst.executeUpdate();// thanh cong: result > 0
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, pst);
		}

		return result;
	}

	public int update(News news) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "UPDATE tintuc SET tenTinTuc = ? , moTa = ? , chiTiet = ?, idDanhMucTin = ? WHERE idTinTuc = ? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, news.getName());
			pst.setString(2, news.getDescription());
			pst.setString(3, news.getDetail());
			pst.setInt(4, news.getCatId());
			pst.setInt(5, news.getId());
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
		String sql = "DELETE FROM tintuc WHERE idTinTuc = ? ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectDB.close(con, pst);
		}
		
		return result;
	}
}
