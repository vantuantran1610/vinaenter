package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDBLibrary {
	private Connection conn = null;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/tintuc?useUnicode=true&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String password = "";

	public Connection getConnectMysql() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.err.println("Không thể nạp driver");
		} catch (SQLException e) {
			System.err.println("Không thể kết nối với database");
		}
		return conn;
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement pst) {
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, Statement st, ResultSet rs) {
		close(rs);
		close(st);
		close(con);
	}

	public void close(Connection con, PreparedStatement pst, ResultSet rs) {
		close(rs);
		close(pst);
		close(con);
	}

	public void close(Connection con, PreparedStatement pst) {
		close(pst);
		close(con);
	}
}
