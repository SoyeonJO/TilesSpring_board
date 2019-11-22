<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnA 리스트</title>
</head>
<body>
	<div id="qnaList_content">
		<div class="panel panel-green">
			<div class="panel-heading">QnA</div>
			<div class="panel-body">

				<table class="table table-hover-color">
					<thead>
						<tr>
							<th scope="col" width="5%">No</th>
							<th scope="col" width="54%">제목</th>
							<th scope="col" width="12%">작성자</th>
							<th scope="col" width="13%">작성일</th>
							<th scope="col" width="15%">조회수</th>
						</tr>
					</thead>
					<tbody id ="boardSelect">
					<c:if test="${empty list }">
						<tr align="center">
							<td colspan="5"> <font color="red">등록된 게시글이 없습니다.</font> </td>
						</tr>
					</c:if>
					 <c:if test="${!empty list }">
							<c:forEach items="${list}" var="boardlist">
								<tr>                          <!-- bo_no를 !rnum처리! -->
									<td><input type="hidden" id="no" value="${boardlist.qa_no}"/>${boardlist.rnum}</td>
									<td align="left">
										<c:forEach begin="1" end="${boardlist.qa_depth }" varStatus="stat">
											&nbsp;&nbsp;&nbsp;
											<c:if test="${stat.last }">
												<i class="fa fa-angle-right"></i>
											</c:if>
										</c:forEach>
										${boardlist.qa_title }</td>
									<td>${boardlist.qa_mem_id}</td>
									<td>${boardlist.qa_reg_date}</td>
									<td>${boardlist.qa_hit}</td>
								</tr>
							</c:forEach>
					   </c:if>
					</tbody>
				</table>
			</div>
	</div>
${pagingUtiles.getPagingHTMLS()}
	<form action="/user/qna/qnaList.do" method="post" class="form-inline pull-right">
			<input id="search_keyword" name ="search_keyword"  type="text" placeholder="검색어 입력..." class="form-control"/> 
			<select class="form-control" name="search_keycode">
				<option>검색조건</option>
				<option value="TOTAL">전체</option>
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
				<option value="NAME">작성자</option>
			</select>
			<button type="submit" class="btn btn-primary form-control">검색</button>
			<button type="button" class="btn btn-info form-control" id ="btn1">게시글 등록</button>
		</form>
	</div>
</body>

<script type="text/javascript">
	$(function(){
		$('#btn1').click(function(){
			if(eval('${!empty LOGIN_MEMBERINFO}')) {
				$(location).attr('href', '${pageContext.request.contextPath}/user/qna/qnaForm.do');
			}else {
				BootstrapDialog.show({
				    title: '경고',
				    message: '로그인해주세요.'
				});
			}  
		});
		
		$('#boardSelect tr').click(function(){
			var qa_no = $(this).find('td:eq(0) input').val();
			var url = '${pageContext.request.contextPath}/user/qna/qnaView.do';
				$(location).attr('href', url + '?qa_no=' + qa_no);
		});

	});

</script>
</html>