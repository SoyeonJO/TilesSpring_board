<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drug Store</title>
</head>
<body>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<div id="wrapper">
		<tiles:insertAttribute name="left"></tiles:insertAttribute>
		<div id="page-wrapper">
			<tiles:insertAttribute name="content_header"></tiles:insertAttribute>
			<div class="page-content">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		if (eval('${!empty param.message}')) {
			BootstrapDialog.show({
				title : '알림',
				message : '${param.message}'
			});
		}
	});
</script>
</html>