<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="include/menu.jsp" />
<c:if test="${sessionScope.userid != null }">
	<h2> ${sessionScope.name} (${sessionScope.userid}) 님의 방문을 환영합니다. </h2>
</c:if>
<%=application.getRealPath("/") %>
</body>
</html>