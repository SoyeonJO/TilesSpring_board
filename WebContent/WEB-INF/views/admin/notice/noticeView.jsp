<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항상세페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="panel panel-black" style="background:#fff;">
   <div class="panel-heading">공지사항</div>
        <div class="panel-body pan">
             <form action="${pageContext.request.contextPath}/admin/notice/updateNotice.do" method="post" id="noticeView">		
            <div class="form-body pal">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                        <input id="notice_no" name="notice_no" type="hidden" placeholder="" class="form-control" />
        				<label for="inputSubject" class="control-label"> 제목</label>

                            <div class="input-icon right">
						<input id="notice_title" name="notice_title" type="text" placeholder="" class="form-control" />
                        </div>
                        </div> 
                        </div> 
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="notice_mem_id" class="control-label">
                                작성자</label>
                            <div class="input-icon right">
                                <input readonly id="notice_mem_id" name="notice_mem_id" type="text" placeholder="" class="form-control" />
                                </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="notice_reg_date" class="control-label">작성일</label>
                            <div class="input-icon right">
                                <input readonly id="notice_reg_date" name="notice_reg_date" type="text" placeholder="" class="form-control" />
                                </div>
                        </div>
                    </div>
                 </div>
                     
                <div class="form-group">
                   <label for="notice_content" class="control-label"> 내용</label>
            
                        <textarea id="notice_content" name="notice_content" rows="5" class="form-control"></textarea>
                        </div>
              	  </div>
           		 <div class="form-group">
				<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ol>
			
					 <div class="carousel-inner" role="listbox" style="height: 200px;">
						<c:forEach items="${noticeInfo.items}" var="fileitem" varStatus="stat">						
							<c:if test="${stat.first }">
								<div class="item active">
							</c:if>
							<c:if test="${stat.last }">
								<div class="item">
							</c:if>
									<img src="/files/${fileitem.fi_not_save_name}" alt="pic2"         
													onclick="javascript:location.href='/admin/notice/noticeFile.do?fileSEQ=${fileitem.fi_not_seq }&notice_no=${fileitem.fi_not_no}';">
								</div>
						</c:forEach>
					</div>
					<!-- Left and right controls -->
					<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div> 
					
            <div class="form-actions text-right pal">
                <button type="submit" class="btn btn-success">수정</button>
				<button type="button" class="btn btn-danger" id="deletebtn">삭제</button>
				<button type="button" class="btn btn-info" id="list">목록</button>
            </div>
            </form>
        </div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$('#notice_no').val('${noticeInfo.notice_no}');
	$('#notice_mem_id').val('${noticeInfo.notice_mem_id}');
 	$('#notice_reg_date').val('${noticeInfo.notice_reg_date}');
 	$('#notice_title').val('${noticeInfo.notice_title}');
 	$('#notice_content').val('${noticeInfo.notice_content}');
 
	
	// 목록버튼
	$('#list').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/noticeList.do');
		}); 
   // 삭제버튼
	$('#deletebtn').click(function(){
		var flag = redirectFlag();
		if(flag){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/deleteNotice.do?notice_no=${noticeInfo.notice_no}');
		}else{
			alertPRT('해당 게시글은 관리자만 삭제할 수 있습니다.');
		}
	});

   	$('form').submit(function(){
   		
   	});
});

function alertPRT(msg){
	BootstrapDialog.show({
	    title: '경고',
	    message: msg
	});
}
function redirectFlag(){
	if('${noticeInfo.notice_mem_id}' == 
	         '${LOGIN_MEMBERINFO.mem_id}'){
			return true;
	}
	return false;
}	
</script>
</html>