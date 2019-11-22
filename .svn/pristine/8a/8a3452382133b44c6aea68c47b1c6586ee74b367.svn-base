<%@ page language="JAVA" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="page-title-breadcrumb">
	<ol class="breadcrumb">
		<li>
			<i class="fa fa-home"></i>&nbsp;
			<c:if test="${!empty LOGIN_MEMBERINFO }">
				<c:if test="${empty LOGIN_ADMININFO }">
					<a href="/user/main/mainTemplate.do">HOME</a>&nbsp;&nbsp;
				</c:if>
			</c:if>
			<c:if test="${!empty LOGIN_ADMININFO }">
				<c:if test="${empty LOGIN_MEMBERINFO }">
					<a href="/admin/main/mainTemplate.do">HOME</a>&nbsp;&nbsp;
				</c:if>
			</c:if>
			<c:if test="${empty LOGIN_MEMBERINFO }">
				<c:if test="${empty LOGIN_ADMININFO }">
					<a href="/user/main/mainTemplate.do">HOME</a>&nbsp;&nbsp;
				</c:if>
			</c:if>
<!-- 			<i class="fa fa-angle-right"></i>&nbsp;&nbsp; -->
		</li>
		<li>
<!-- 			<a href="#">???</a>&nbsp;&nbsp; -->
<!-- 			<i class="fa fa-angle-right"></i>&nbsp;&nbsp; -->
		</li>
<!-- 		<li class="active">???</li> -->
	</ol>
	<div class="clearfix"></div>
</div>
</body>
</html>