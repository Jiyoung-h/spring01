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
<script>
//구글 차트 라이브러리 로딩
	google.load('visualization', '1',
			 {'packages':['corechart']});
//로딩이 완료되면 drawChart 함수 호출
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		var jsonData = $.ajax({
			url : "${path}/chart/cart_money_list.do",
			dataType : "json",
			async : false
		}).responseText;
		console.log(jsonData);
		// 데이터 테이블 생성
		var data = new google.visualization.DataTable(jsonData);
		var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		chart.draw(data, {
			title : "장바구니 통계",
			width : 600,
			height : 440
		});
	}
</script>
<body>
<div id="chart_div"></div>
<button id="btn" type="button" onclick="drawChart()">refresh</button>
</body>
</html>