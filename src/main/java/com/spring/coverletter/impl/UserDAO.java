package com.spring.coverletter.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.spring.coverletter.common.JDBCUtil;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void insertUser(UserDO udo) {
		System.out.println("-- insertUser() 贸府 -- ");
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into users (id,pw,name,age) values " 
			+ "(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udo.getId());
			pstmt.setString(2, udo.getPw());
			pstmt.setString(3, udo.getName());
			pstmt.setInt(4, udo.getAge());
			
			pstmt.executeUpdate();
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(insertUser --)");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<UserDO> getUserList(){
		System.out.println("-- getUserList() 贸府 --");
		ArrayList<UserDO> uList = new ArrayList<UserDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserDO udo = new UserDO();
				udo.setId(rs.getString(1));
				udo.setPw(rs.getString(2));
				udo.setName(rs.getString(3));
				udo.setAge(rs.getInt(4));
				
				uList.add(udo);
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(getUserList() --");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return uList;
	}
	
	public UserDO getMyInfo(String user_id) {
		UserDO udo = new UserDO();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from users where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				udo.setId(user_id);
				udo.setPw(rs.getString("pw"));
				udo.setName(rs.getString("name"));
				udo.setAge(rs.getInt("age"));
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(getMyInfo() --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return udo;
	}
	
	public UserDO modifyMyinfo(UserDO udo,String user_id) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update users set name=?,id=?,pw=?,age=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,udo.getName());
			pstmt.setString(2,udo.getId());
			pstmt.setString(3,udo.getPw());
			pstmt.setInt(4,udo.getAge());
			pstmt.setString(5,user_id);
			pstmt.executeUpdate();
			
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(modifyMyinfo --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return udo;
	}
	
	public void setLoginDate(String user_id) {
        LocalDateTime now = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(now);
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update users set lastLogin=? where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setTimestamp(1,timestamp);
			pstmt.setString(2,user_id);
			pstmt.executeUpdate();
			
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(setLoginDate --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String user_id) {
        LocalDateTime now = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(now);
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update users set deleteDate=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1,timestamp);
			pstmt.setString(2,user_id);
			pstmt.executeUpdate();
			
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(deleteUser --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
