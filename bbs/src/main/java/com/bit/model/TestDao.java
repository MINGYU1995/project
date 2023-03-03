package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TestDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	   
	public void getConnection() {
		String url="jdbc:mysql://localhost:3306/lecture";
		String user="scott";
		String password="tiger";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn==null || conn.isClosed())
					conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertOne(String name , String title, String content) throws SQLException {
		String sql = "insert into testing(name,title,content) values(?,?,?)";
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}
	
	public List<TestDto> findAll() throws SQLException{
		String sql="select * from testing";
		List<TestDto> list=new ArrayList<TestDto>();
		
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestDto bean=new TestDto();
				bean.setContent(rs.getString("content"));
				bean.setName(rs.getString("name"));
				bean.setTitle(rs.getString("title"));
				list.add(bean);
			}
		} finally {
			 if(rs!=null)rs.close();
	         if(pstmt!=null)pstmt.close();
	         if(conn!=null)conn.close();  
		}
		return list;
	}
}
