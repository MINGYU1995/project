<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.bit.ajax.model.TestDao" %>
<%@ page import="com.bit.ajax.model.TestDto" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
	<meta charset="UTF-8">
    <title>DB test-page</title>
	</head>
	<body>
		<%
			TestDao testdao = new TestDao();
			ArrayList<TestDto> dtos = testdao.User_Select();
		
			for(int i=0; i <dtos.size(); i++){
				TestDto dto = dtos.get(i);
				out.println(dto.getName());
				out.println(dto.getTitle());
				out.println(dto.getContent());
			}
		%>
	</body>
</html>