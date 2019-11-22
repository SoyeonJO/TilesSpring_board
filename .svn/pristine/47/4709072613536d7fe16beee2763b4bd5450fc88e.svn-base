<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('#memberListTBY tr').click(function() {
			var mem_id = $(this).find('td:eq(0)').text();
			var url = '${pageContext.request.contextPath}/admin/mypage/memberInfo.do';
			$(location).attr('href', url + '?mem_id=' + mem_id);
		});
	});
</script>
</head>
<body>
	<ul class="nav nav-pills">
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/mypage.do">Profile</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/statistics.do">Statistics &nbsp;</a>
		</li>
		<li class="active">
			<a href="${pageContext.request.contextPath }/admin/mypage/memberStatus.do">MemberStatus &nbsp;</a>
		</li>
	</ul>
	<nav role="navigation" class="navbar navbar-default">
	    <div class="container-fluid">
	        <div class="navbar-header">
	            <button type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" class="navbar-toggle">
	            	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
	            </button>
	            <a href="#" class="navbar-brand">MemberStatus</a>
			</div>
	        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="${pageContext.request.contextPath }/admin/mypage/memberStatus.do">가입 회원</a></li>
	                <li><a href="/admin/mypage/withdrawmemStatus.do">탈퇴 회원</a></li>
	            </ul>
	            <form role="search" class="navbar-form navbar-right" method="POST" action="${pageContext.request.contextPath }/admin/mypage/memberStatus.do">
	                <div class="form-group">
	                	<input type="text" name="search_keyword" id="search_keyword" placeholder="Search" class="form-control"/>
	                </div> &nbsp;
	                <button type="submit" class="btn btn-green">Submit</button>
	            </form>
	        </div>
	    </div>
	</nav>
	<!-- 표 시작 -->
	<div class="panel panel-black">
        <div class="panel-heading">내가 쓴 게시글</div>
        <div class="panel-body">
            <table class="table table-hover-color">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Nick</th>
                    <th>Mail</th>
                    <th>Birth</th>
                    <th>Tel</th>
                    <th>Addr</th>
                </tr>
                </thead>
                <tbody id="memberListTBY">
      			<c:if test="${empty memberList }">
					<tr align="center">
						<td colspan="7"> <font color="red">가입된 회원이 없습니다.</font> </td>
					</tr>
				</c:if>
                <c:if test="${!empty memberList }">
	                <c:forEach items="${memberList }" var="memberInfo">
	                <tr>
	                    <td>${memberInfo.mem_id }</td>
	                    <td>${memberInfo.mem_name }</td>
	                    <td>${memberInfo.mem_nick }</td>
	                    <td>${memberInfo.mem_mail }</td>
	                    <td>${fn:substringBefore(memberInfo.mem_birth, ' ') }</td>
	                    <td>${memberInfo.mem_tel }</td>
	                    <td>${memberInfo.mem_addr1 } ${memberInfo.mem_addr2 } </td>
	                </tr>
	                </c:forEach>
                </c:if>
<!--                 <tr> -->
<!--                     <td>2</td> -->
<!--                     <td>John</td> -->
<!--                     <td>45</td> -->
<!--                     <td><span class="label label-sm label-info">Pending</span></td> -->
<!--                     <td><span class="label label-sm label-success">Approved</span></td> -->
<!--                     <td><span class="label label-sm label-warning">Suspended</span></td> -->
<!--                     <td><span class="label label-sm label-danger">Blocked</span></td> -->
<!--                 </tr> -->
                </tbody>
            </table>
            ${paginationContent }
        </div>
    </div>




</body>
</html>