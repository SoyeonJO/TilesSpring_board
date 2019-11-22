<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$('#qa_no').val('${qnaInfo.qa_no}');
		$('#qa_title').val('${qnaInfo.qa_title}');
		$('#qa_mem_id').val('${qnaInfo.qa_mem_id }');
		$('#qa_reg_date').val('${qnaInfo.qa_reg_date }');
		$('#qa_content').val('${qnaInfo.qa_content }');
		
		$('#qnaListBtn').click(function(){
			$(location).attr('href', '/user/qna/qnaList.do');
		});
		
		$('#deleteBtn').click(function(){
			var flag = redirectFlag();
			
			if(flag){
				$(location).attr('href', '${pageContext.request.contextPath}/user/qna/deleteQnaInfo.do?qa_no=${qnaInfo.qa_no}');
			}else{
				alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
			}
			
		});
		
		$('#qnaView').submit(function(){
			var flag = redirectFlag();
			
			if(flag){
				$(location).attr('action', '${pageContext.request.contextPath}/user/qna/updateQnaInfo.do');
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
		if('${qnaInfo.qa_mem_id}' == 
		         '${LOGIN_MEMBERINFO.mem_id}'){
				return true;
		}
		return false;
	}	
</script>
</head>
<body>
<div class="panel panel-black" style="background:#fff;">
        <div class="panel-heading">QnA</div>
        <div class="panel-body pan">
            <form action="#" method="post" id="qnaView">
            <div class="form-body pal">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                        <input id="qa_no" name="qa_no" type="hidden" placeholder="" class="form-control" />
                            <label for="news_title" class="control-label" >
                                제목</label>
                            <div class="input-icon right">
                                <input id="qa_title" name="qa_title" type="text" placeholder="" class="form-control" />
                                </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="qa_mem_id" class="control-label">
                                작성자</label>
                            <div class="input-icon right">
                                <input readonly id="qa_mem_id" name="qa_mem_id" type="text" placeholder="" class="form-control" />
                                </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="news_reg_date" class="control-label">
                                작성일</label>
                            <div class="input-icon right">
                                <input readonly id="qa_reg_date" name="qa_reg_date" type="text" placeholder="" class="form-control" />
                                </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="news_content" class="control-label">
                        내용</label><textarea id="qa_content" name="qa_content" rows="5" class="form-control"></textarea>
                </div>
            </div>
<!--            		 <div class="form-group"> -->
<!-- 				<label class="control-label col-sm-2" for="bo_content">첨부파일:</label> -->
<!-- 				<div id="myCarousel" class="carousel slide" data-ride="carousel"> -->
<!-- 					<ol class="carousel-indicators"> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 					</ol> -->
			
<!-- 					 <div class="carousel-inner" role="listbox" style="height: 200px;"> -->
<%-- 						<c:forEach items="${qnaInfo.items }" var="qnaitem" varStatus="stat"> --%>
<%-- 							<c:if test="${stat.first }"> --%>
<!-- 								<div class="item active"> -->
<%-- 							</c:if> --%>
<%-- 							<c:if test="${stat.last }"> --%>
<!-- 								<div class="item"> -->
<%-- 							</c:if> --%>
<%-- 									<img src="/files/${qnaitem.fi_qa_save_name }" alt="pic2" onclick="javascript:location.href='/user/news/newsItem.do?finewsSEQ=${qnaitem.fi_qa_seq }&news_no=${qnaitem.fi_qa_no}';"> --%>
<!-- 								</div> -->
<%-- 						</c:forEach> --%>
<!-- 					</div> -->
<!-- 					Left and right controls -->
<!-- 					<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a> -->
<!-- 					<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a> -->
<!-- 				</div>  -->
					
            <div class="form-actions text-right pal">
                <button type="submit" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-primary" id="deleteBtn">삭제</button>
                <button type="button" class="btn btn-primary" id="qnaListBtn">목록</button>
            </div>
            </form>
        </div>
</div>
</body>
</html>