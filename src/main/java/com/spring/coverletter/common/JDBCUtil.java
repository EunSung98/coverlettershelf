package com.spring.coverletter.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	static String id = "root";
	static String pass = "";
	static String url = "jdbc:mysql://localhost:3306/coverletter?characterEncoding=utf-8";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mysql driver loading success");

			return DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				if (!pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
	}
}
