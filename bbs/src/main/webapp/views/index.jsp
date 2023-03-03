<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> <!--jQuery 불러오기-->
    <script>
        $(document).ready(function(){ 
	        $.ajax({
	            url: "http://192.168.99.100/:8080/bbs/ajax/list", // 목적지
	            type: "GET", // HTTP Method
	            success : function(result) {
					$('#list').html(result);
				}
	        });
        });
    </script>
</head>
<body>
<center>
    <form id="theForm" method="post" action="http://192.168.99.100/:8080/bbs/ajax/insert.do">
    
        <table border="1">
            <tr>
                <th>이름</th>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                 <th>제목</th>
                 <td><input type="text" id="title" name="title"></td>
            </tr>
                <th>내용</th>
                <td><input type="text" id="content" name="content"></td>
        </table>
        <br>
        <button>제출</button>
    </form>
    <br>
    <fieldset style="width:700px">
		<legend>게시판</legend>
    <table width="90%">
		<thead>
			<tr>
	            <th>이름</th>	
	            <th>제목</th>
	            <th>내용</th>			
			</tr>
		</thead>
        <tbody id="list">
        	
        	
        </tbody>
    </table>
    </fieldset>
    </center>
</body>
</html>