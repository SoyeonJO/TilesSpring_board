<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page-content">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
		</div>	
	</div>
</body>
</html>