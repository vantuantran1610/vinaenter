package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.Hoa;

public class HoaDAO {
	private ConnectDBLibrary connectDB;
	private Statement st;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pst;

	public HoaDAO() {
		connectDB = new ConnectDBLibrary();
	}
	
	
	//phuong thuc lay ra tat ca danh sach hoa 
	public ArrayList<Hoa> getAll() {
		ArrayList<Hoa> listHoa = new ArrayList<>();
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM hoa ORDER BY id_hoa DESC";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Hoa objHoa = new Hoa(rs.getInt("id_hoa"), rs.getString("ten_hoa"), rs.getString("mo_ta"),
						rs.getString("hinh_anh"), rs.getInt("gia_ban"));
				listHoa.add(objHoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, st, rs);
		}

		return listHoa;
	}
	
	//phuong thuc them hoa
	public int add(Hoa objHoa) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "INSERT INTO hoa (ten_hoa, mo_ta, hinh_anh, gia_ban) VALUE (?, ?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objHoa.getName());
			pst.setString(2, objHoa.getDescription());
			pst.setString(3, objHoa.getPicture());
			pst.setInt(4, objHoa.getPrice());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(con, pst);
		}
		return result;
	}
	
	//phuong thuc lay du lieu theo id
	public Hoa findById(int id) {
		Hoa objHoa = null;
		con = connectDB.getConnectMysql();
		String sql = "SELECT * FROM hoa WHERE id_hoa = ?";
		try {
			pst =  con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				objHoa = new Hoa(rs.getInt("id_hoa"), rs.getString("ten_hoa"), rs.getString("mo_ta"),
						rs.getString("hinh_anh"), rs.getInt("gia_ban"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectDB.close(con, pst, rs);
		}
		
		return objHoa;
	}
	
	//phương thức cập nhật dữ liệu(sửa)
	public int update(Hoa objHoa) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "UPDATE hoa SET ten_hoa = ?, mo_ta = ?, hinh_anh = ?, gia_ban = ? WHERE id_hoa = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objHoa.getName());
			pst.setString(2, objHoa.getDescription());
			pst.setString(3, objHoa.getPicture());
			pst.setInt(4, objHoa.getPrice());
			pst.setInt(5, objHoa.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectDB.close(con, pst);
		}
		return result;
	}
	
	//phương thức xóa dữ liệu
	public int delete(int id) {
		int result = 0;
		con = connectDB.getConnectMysql();
		String sql = "DELETE FROM hoa WHERE id_hoa = ?";
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
