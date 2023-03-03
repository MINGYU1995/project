package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.TestDao;
import com.bit.model.TestDto;

@WebServlet("/ajax/list")
public class InsertAjax extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		 resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Credentials", "true");
		PrintWriter out=resp.getWriter();
		TestDao dao=new TestDao();
		List<TestDto> list=null;
		
		try {
			list=dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(TestDto bean: list) {
			out.print("<tr>");
			out.print("<td style=\"text-align: center\">"+bean.getName()+"</td>");
			
			out.print("<td style=\"text-align: center\"> "+bean.getTitle()+"</td>");
			
			out.print("<td style=\"text-align: center\">"+bean.getContent()+"</td>");
			out.print("</tr>");
		}
		out.flush();
		out.close();
	}
}
