<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<title>Insert title here</title>
</head>
<jsp:include page="../include/admin_menu.jsp" />
<body>
<h2>이메일 보내기</h2>
<form method="post" action="${path }/email/send.do">
	발신자 이름 : <input name="senderName"><br>
	발신자 이메일주소 : <input name="senderMail"><br>
	수신자 이메일주소 : <input name="receiveMail"><br>
	제목 : <input name="subject"><br>
	내용 : <textarea rows="5" cols="80" name="message"></textarea><br>
	<input type="submit" value="전송">
</form>
<span style="color:red;">${message }</span>
</body>
</html>