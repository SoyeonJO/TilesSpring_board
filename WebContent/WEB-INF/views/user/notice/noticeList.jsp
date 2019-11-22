<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
</head>
<body>
<div class="panel panel-green" id="newsList_content">
	<div class="panel-heading">공지사항</div>
        <div class="panel-body">
            <table class="table table-hover-color">
                <thead>
                <tr>
                    <th>NO</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
                </thead>
			<tbody id="noticeSelect">
			
			 <c:forEach items="${list }" var="noticelist">
				<tr>
					<td>${noticelist.notice_no}</td>
					<td>${noticelist.notice_title}</td>
					<td>${noticelist.notice_reg_date}</td>
					<td>${noticelist.notice_hit}</td>
				</tr>
			 </c:forEach>
			
			</tbody>
		</table>
		${page}
	</div>

</div>	
<div >
<form action="${pageContext.request.contextPath }/user/notice/noticeList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" id="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
</form> 
</div>	
</body>
<script type="text/javascript">
$(function(){
	
	$('#noticeSelect tr').click(function(){
		var notice_no = $(this).find('td:eq(0)').text();
		var rnum = $(this).find('td:eq(0)').text();
		var url = '${pageContext.request.contextPath}/user/notice/noticeView.do';
		$(location).attr('href', url + '?notice_no=' + notice_no + '&rnum=' + rnum);
	});
	
});
</script>
</html>