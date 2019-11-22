<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
	google.charts.load("current", {packages:["corechart"]});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
	
      var data = google.visualization.arrayToDataTable([
	     ['Task', 'Hours per Day'],
	     
	     <c:forEach items="${nameList}" var="name" varStatus="status">
			['${name.md_ct_name}', '${cntList[status.index]}'*1], 
		  </c:forEach>
	  ]);
     
      
	  var options = {
	    title: '약 검색 통계',
	    is3D: true,
	  };
	
	  var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
	  chart.draw(data, options);
	}
</script>
</head>
<body>
	<ul class="nav nav-pills">
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/mypage.do">Profile</a>
		</li>
		<li class="active">
			<a href="${pageContext.request.contextPath }/admin/mypage/statistics.do">Statistics &nbsp;</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/memberStatus.do">MemberStatus &nbsp;</a>
		</li>
	</ul>
	<nav role="navigation" class="navbar navbar-default">
	    <div class="container-fluid">
	        <div class="navbar-header">
	            <button type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" class="navbar-toggle">
	            	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
	            </button>
	            <a href="#" class="navbar-brand">Statistics</a>
			</div>
	        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
	            <ul class="nav navbar-nav">
	                <li><a href="${pageContext.request.contextPath }/admin/mypage/statistics.do">통계</a></li>
	                <li><a href="${pageContext.request.contextPath }/admin/mypage/insertDateStatistics.do">회원가입 월 통계</a></li>
	                <li class="active"><a href="${pageContext.request.contextPath }/admin/mypage/drugStatistics.do">약 검색 통계</a></li>
	            </ul>
	            <form role="search" class="navbar-form navbar-right" method="GET" action="${pageContext.request.contextPath }/user/mypage/myBoardWritten.do">
	                <div class="form-group">
	                	<input type="text" name="search_keyword" id="search_keyword" placeholder="Search" class="form-control"/>
	                </div> &nbsp;
	                <button type="submit" class="btn btn-green">Submit</button>
	            </form>
	        </div>
	    </div>
	</nav>
	<h3>약 검색 통계</h3>
	<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</body>
</html>