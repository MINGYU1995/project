package com.bit.ajax.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TestDao {
	private static TestDao instance = new TestDao();
	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 드라이버 로딩
	public TestDao(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");			
	        } catch (ClassNotFoundException e) {
	            System.err.println("<JDBC 오류> Driver load 오류: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	public static TestDao getInstance() {
		return instance;
	}
	
	// select 구문
	public void User_Insert(String name , String title, String content){
		String server = "jdbc:mysql://localhost:3306"; // 서버 주소
		String database = "lecture"; // DATABASE 이름
		String Suser_name = "scott"; // 서버 아이디
		String Spassword = "tiger"; // 서버 비밀번호
		String sql = "insert into testing(name,title,content) values(?,?,?)";
		
			try {
				con = DriverManager.getConnection(server + "/" + database + "?useSSL=false", Suser_name, Spassword);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				pstmt.executeUpdate(); // 등록후에 끝.
				
			} catch (SQLException e) {
				System.err.println("con 오류:" + e.getMessage());
				e.printStackTrace();
			} finally {
				try { // 종료
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public ArrayList<TestDto> User_Select() {
		String server = "jdbc:mysql://localhost:3306"; // 서버 주소
		String database = "lecture"; // DATABASE 이름
		String Suser_name = "scott"; // 서버 아이디
		String Spassword = "tiger"; // 서버 비밀번호

		ArrayList<TestDto> dtos = new ArrayList<TestDto>();
		// 연결
		try {
			con = DriverManager.getConnection(server + "/" + database + "?useSSL=false", Suser_name, Spassword);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM testing");
			System.out.println("Connect completed.");

			while (rs.next()) {
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
			
				TestDto dto = new TestDto(name,title,content);
				dtos.add(dto);
			}

		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try { // 종료
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
}
