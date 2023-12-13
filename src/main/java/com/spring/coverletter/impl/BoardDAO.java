package com.spring.coverletter.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.spring.coverletter.common.JDBCUtil;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Integer uploadBoard(BoardDO bdo) {
		System.out.println("-- uploadBoard 贸府 -- ");
		
		int board_id = -1;
		 
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into board (writer_id,company,job,result,open,date) VALUES " 
			+ "(?,?,?,?,?,?)";
			
			LocalDate now = LocalDate.now();
			
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bdo.getWriter_id());
            pstmt.setString(2, bdo.getCompany());
            pstmt.setString(3, bdo.getJob());
            pstmt.setString(4, bdo.getResult());
            pstmt.setString(5, bdo.getOpen());
            pstmt.setDate(6, Date.valueOf(now));			
			
			pstmt.executeUpdate();
			
	        ResultSet generatedKeys = pstmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	board_id = generatedKeys.getInt(1);
	        }
	        
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(uploadBoard --)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return board_id;
	}
	
	public ArrayList<BoardDO> getMyBoardList(String user_id){
		System.out.println("-- getMyBoardList() 贸府 --");
		
		ArrayList<BoardDO> bList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where writer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDO bdo = new BoardDO();
				
				System.out.println();
				
                bdo.setBoard_id(rs.getInt("board_id"));
                bdo.setWriter_id(rs.getString("writer_id"));
                bdo.setCompany(rs.getString("company"));
                bdo.setJob(rs.getString("job"));
                bdo.setResult(rs.getString("result"));
                bdo.setOpen(rs.getString("open"));
                bdo.setDate(rs.getDate("date"));
				
				bList.add(bdo);
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(getMyBoardList() --");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	public ArrayList<BoardDO> getPublicBoardList(){
		System.out.println("-- getPublicBoardList() 贸府 --");
		
		ArrayList<BoardDO> bList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where open = 'on'";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDO bdo = new BoardDO();
				
				System.out.println();
				
	            bdo.setBoard_id(rs.getInt("board_id"));
	            bdo.setWriter_id(rs.getString("writer_id"));
	            bdo.setCompany(rs.getString("company"));
	            bdo.setJob(rs.getString("job"));
	            bdo.setResult(rs.getString("result"));
	            bdo.setOpen(rs.getString("open"));
	            bdo.setDate(rs.getDate("date"));
				
				bList.add(bdo);
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(getPublicBoardList --");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	public BoardDO goMyPage(Integer board_id,String user_id) {
		System.out.println("goMyPage() 贸府 矫累");

		BoardDO bdo = new BoardDO();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where board_id=? and writer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_id);
			pstmt.setString(2, user_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
	            bdo.setBoard_id(rs.getInt("board_id"));
	            bdo.setWriter_id(rs.getString("writer_id"));
	            bdo.setCompany(rs.getString("company"));
	            bdo.setJob(rs.getString("job"));
	            bdo.setResult(rs.getString("result"));
	            bdo.setOpen(rs.getString("open"));
	            bdo.setDate(rs.getDate("date"));
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(goMyPage --");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bdo;

	}
	
	public BoardDO goTotalPage(Integer board_id) {
		System.out.println("goTotalPage() 贸府 矫累");

		BoardDO bdo = new BoardDO();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where board_id=? and  open='on'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
	            bdo.setBoard_id(rs.getInt("board_id"));
	            bdo.setWriter_id(rs.getString("writer_id"));
	            bdo.setCompany(rs.getString("company"));
	            bdo.setJob(rs.getString("job"));
	            bdo.setResult(rs.getString("result"));
	            bdo.setOpen(rs.getString("open"));
	            bdo.setDate(rs.getDate("date"));
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(goTotalPage --");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bdo;

	}
	
	public void modifyBoard(BoardDO bdo) {
		System.out.println("modifyBoard() 贸府 矫累");
		
		try {
			conn = JDBCUtil.getConnection();

			String sql = "update board set company=?,job=?,result=?,date=?,open=? "
					+ "where board_id=? and writer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bdo.getCompany());
			pstmt.setString(2, bdo.getJob());
			pstmt.setString(3, bdo.getResult());
			pstmt.setDate(4,Date.valueOf(java.time.LocalDate.now()));
			pstmt.setString(5,bdo.getOpen());
			pstmt.setInt(6, bdo.getBoard_id());
			pstmt.setString(7,bdo.getWriter_id());
			pstmt.executeUpdate();
			
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("modifyBoard() 贸府 肯丰");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBoard(Integer board_id,String user_id) {
		System.out.println("deleteBoard() 贸府 矫累");

		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from board where board_id=? and writer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_id);
			pstmt.setString(2, user_id);
			pstmt.executeUpdate();
			
			JDBCUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard() 贸府 肯丰");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<BoardDO> SearchBoard(String type, String keyword) {

		ArrayList<BoardDO> bList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where " + type + " like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDO bdo = new BoardDO();
				
				System.out.println();
				
	            bdo.setBoard_id(rs.getInt("board_id"));
	            bdo.setWriter_id(rs.getString("writer_id"));
	            bdo.setCompany(rs.getString("company"));
	            bdo.setJob(rs.getString("job"));
	            bdo.setOpen(rs.getString("open"));
	            bdo.setDate(rs.getDate("date"));
				
				bList.add(bdo);
			}
			
			JDBCUtil.close(rs, pstmt, conn);
			System.out.println("SearchBoard() 贸府 肯丰");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	public ArrayList<BoardDO> PublicSearchBoard(String type, String keyword) {

		ArrayList<BoardDO> bList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from board where " + type + " like ? and open = 'on'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDO bdo = new BoardDO();
				
				System.out.println();
				
	            bdo.setBoard_id(rs.getInt("board_id"));
	            bdo.setWriter_id(rs.getString("writer_id"));
	            bdo.setCompany(rs.getString("company"));
	            bdo.setJob(rs.getString("job"));
	            bdo.setResult(rs.getString("result"));
	            bdo.setOpen(rs.getString("open"));
	            bdo.setDate(rs.getDate("date"));
				
				bList.add(bdo);
			}
			
			JDBCUtil.close(rs, pstmt, conn);
			System.out.println("PublicSearchBoard() 贸府 肯丰");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
}
