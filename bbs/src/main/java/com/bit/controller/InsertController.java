package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.TestDao;

@WebServlet("/insert.do")
public class InsertController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		TestDao dao=new TestDao();
		try {
			dao.insertOne(name, title, content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("index.do");
	}
}
