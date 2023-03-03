<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.ajax.model.TestDao" %>
<%@ page import="com.bit.ajax.model.TestDto" %>
<%@ page import="java.util.ArrayList" %>


<% //insert db 생성 
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	TestDao testdao = new TestDao();
	testdao.User_Insert(name,title,content);
	ArrayList<TestDto> dtos = testdao.User_Select();
	
for(int i=0; i <dtos.size(); i++){
	TestDto dto = dtos.get(i);
	name = dto.getName();
	title = dto.getTitle();
	content = dto.getContent();
}
	
%>
{
	<% 
	(int i=0; i <dtos.size(); i++){
		TestDto dto = dtos.get(i);
	}
	%>
	"name" : "<%=name %>",
	"title" : "<%=title%>",
	"content" : "<%=content %>"		

}

