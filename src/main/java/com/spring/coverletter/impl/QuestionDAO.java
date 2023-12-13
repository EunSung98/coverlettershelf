package com.spring.coverletter.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.coverletter.common.JDBCUtil;

public class QuestionDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<QuestionsDO> getQuestionList(Integer board_id){
		System.out.println("-- getQuestionList() 贸府 --");
		
		ArrayList<QuestionsDO> qList = new ArrayList<QuestionsDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from questions where board_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuestionsDO qdo = new QuestionsDO();
				qdo.setQuestion_id(rs.getInt("question_id"));
	            qdo.setBoard_id(board_id);
	            qdo.setQuestion(rs.getString("question"));
	            qdo.setContent(rs.getString("content"));
	            
				qList.add(qdo);
			}

			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(getQuestionList --");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return qList;
	}

	public void uploadQuestions(QuestionsDO qdo,Integer board_id) {
		System.out.println("-- uploadQuestions 贸府 -- ");
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into questions (question,content,board_id) VALUES " 
			+ "(?,?,?)";

			pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, qdo.getQuestion());
            pstmt.setString(2, qdo.getContent());
            pstmt.setInt(3, board_id);			
			
			pstmt.executeUpdate();
			JDBCUtil.close(rs, pstmt, conn);
			
			System.out.println("-- database 贸府 肯丰(uploadQuestions --)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<QuestionsDO> modifyQuestions(QuestionsDO qdo) {
	    System.out.println("-- modifyQuestions() 贸府 --");

	    ArrayList<QuestionsDO> qList = new ArrayList<QuestionsDO>();

	    try {
	        conn = JDBCUtil.getConnection();
	        String sql = "update questions set question=?, content=? where board_id=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, qdo.getQuestion());
	        pstmt.setString(2, qdo.getContent());
	        pstmt.setInt(3, qdo.getBoard_id());

	        pstmt.executeUpdate();

	        qList = getQuestionList(qdo.getBoard_id());

	        JDBCUtil.close(rs, pstmt, conn);

	        System.out.println("-- database 贸府 肯丰(modifyQuestions) --");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return qList;
	}

}
