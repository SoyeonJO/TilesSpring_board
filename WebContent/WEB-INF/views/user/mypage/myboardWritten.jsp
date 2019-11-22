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
		$('#freeboardListTBY tr').click(function() {
			var bo_no = $(this).find('td:eq(0) input').val();
			var url = '${pageContext.request.contextPath}/user/freeboard/freeboardView.do';
			$(location).attr('href', url + '?bo_no=' + bo_no);
		});
	});
</script>
</head>
<body>
	<ul class="nav nav-pills">
        <li>
        	<a href="${pageContext.request.contextPath }/user/mypage/mypage.do">Profile</a>
        </li>
        <li class="active">
        	<a href="${pageContext.request.contextPath }/user/mypage/myBoardWritten.do">My board</a>
        </li>
    </ul>
	<div class="clearfix"></div>
	<hr>
	<nav role="navigation" class="navbar navbar-default">
	    <div class="container-fluid">
	        <div class="navbar-header">
	            <button type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" class="navbar-toggle">
	            	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
	            </button>
	            <a href="#" class="navbar-brand">MyBoard</a>
			</div>
	        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="${pageContext.request.contextPath }/user/mypage/myBoardWritten.do">자유게시판</a></li>
	                <li><a href="${pageContext.request.contextPath }/user/mypage/searchQnaBoard.do">QnA게시판</a></li>
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
	
	<div class="panel panel-black">
        <div class="panel-heading">내가 쓴 게시글</div>
        <div class="panel-body">
            <table class="table table-hover-color">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Title</th>
                    <th>Date</th>
                    <th>Hit</th>
                </tr>
                </thead>
                <tbody id="freeboardListTBY">
      			<c:if test="${empty boardList }">
					<tr align="center">
						<td colspan="5"> <font color="red">등록된 게시글이 없습니다.</font> </td>
					</tr>
				</c:if>
                <c:if test="${!empty boardList }">
	                <c:forEach items="${boardList }" var="boardinfo">
	                <tr>
	                    <td id="rnum"><input type="hidden" id="no" value="${boardinfo.bo_no }"/>${boardinfo.rnum }</td>
	                    <td id="title">${boardinfo.bo_title }</td>
	                    <td id="date">${fn:substringBefore(boardinfo.bo_reg_date, ' ') }</td>
	                    <td id="hit">${boardinfo.bo_hit }</td>
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