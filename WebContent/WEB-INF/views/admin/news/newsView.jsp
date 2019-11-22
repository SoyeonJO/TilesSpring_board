<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보도자료 상세페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<style>
</style>
<body>
<div class="panel panel-black" style="background:#fff;">
        <div class="panel-heading">보도자료</div>
        <div class="panel-body pan">
            <form action="${pageContext.request.contextPath}/admin/news/updateNewsInfo.do" method="post" id="newsView">
            <div class="form-body pal">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                        <input id="news_no" name="news_no" type="hidden" placeholder="" class="form-control" />
                            <label for="news_title" class="control-label" >
                                제목</label>
                            <div class="input-icon right">
                                <input id="news_title" name="news_title" type="text" placeholder="" class="form-control" /></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="news_mem_id" class="control-label">
                                작성자</label>
                            <div class="input-icon right">
                                <input readonly id="news_mem_name" name="news_mem_name" type="text" placeholder="" class="form-control" /></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="news_reg_date" class="control-label">
                                작성일</label>
                            <div class="input-icon right">
                                <input readonly id="news_reg_date" name="news_reg_date" type="text" placeholder="" class="form-control" /></div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="news_content" class="control-label">
                        내용</label><textarea id="news_content" name="news_content" rows="5" class="form-control"></textarea>
                </div>
            </div>
           		 <div class="form-group">
				<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ol>
			
					 <div class="carousel-inner" role="listbox" style="width: 200px; height: 200px;">
						<c:forEach items="${newsInfo.items }" var="newsitem" varStatus="stat">
							<c:if test="${stat.first }">
								<div class="item active">
							</c:if>
							<c:if test="${stat.last }">
								<div class="item">
							</c:if>
									<img src="/files/${newsitem.fi_news_save_name }" alt="pic2" onclick="javascript:location.href='/user/news/newsItem.do?finewsSEQ=${newsitem.fi_news_seq }&news_no=${newsitem.fi_news_no}';">
								</div>
						</c:forEach>
					</div>
					<!-- Left and right controls -->
					<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div> 
					
            <div class="form-actions text-right pal">
                <button type="submit" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-primary" id="deleteBtn">삭제</button>
                <button type="button" class="btn btn-primary" id="newsListBtn">목록</button>
            </div>
            </form>
        </div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$('#news_no').val('${newsInfo.news_no}');
	$('#news_title').val('${newsInfo.news_title}');
	$('#news_mem_name').val('${newsInfo.news_mem_name }');
	$('#news_reg_date').val('${newsInfo.news_reg_date }');
	$('#news_content').val('${newsInfo.news_content }');
	
// 	$('#newsView').submit(function(){
// 		var flag = redirectFlag();
// 		news_no = $('#news_no').val();
// 		if(flag){
// 			$(this).attr('href', '${pageContext.request.contextPath}/user/news/updateNewsInfo.do');
// 		}else{
// 			alertPRT('해당 게시글은 작성자만 수정할 수 있습니다.');
// 		}
// 		return flag;
// 	});
	
	$('#newsListBtn').click(function(){
		$(location).attr('href', '/admin/news/newsList.do');
	});
	
	$('#deleteBtn').click(function(){
		var flag = redirectFlag();
		
		if(flag){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/news/deleteNewsInfo.do?news_no=${newsInfo.news_no}');
		}else{
			alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
		}
		
	});
});

function alertPRT(msg){
	BootstrapDialog.show({
	    title: '경고',
	    message: msg
	});
}
function redirectFlag(){
	if('${newsInfo.news_mem_id}' == 
	         '${LOGIN_ADMININFO.mem_id}'){
			return true;
	}
	return false;
}	
</script>
</html>