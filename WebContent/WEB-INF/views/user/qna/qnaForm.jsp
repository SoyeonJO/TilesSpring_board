<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnA 작성하기</title>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> -->
<script>
	$(function(){
		$('#qnaForm').submit(function(){
			title = $('#qa_title').val().trim();
			content = $('#qa_content').val().trim();
			
			if(title.length <= 0){
				alert('제목을 입력해주세요.');
				return false;
			}	
			
			if(content.length <= 0){
				alert('내용을 입력해주세요.');
				return false;
			}
			
		});
	});
</script>
</head>
<body>
	<div class="panel panel-black" style="background:#fff;">
        <div class="panel-heading">QnA</div>
        <div class="panel-body pan">
            <form id="qnaForm" action="#" method="POST" enctype="multipart/form-data">
            <div class="form-body pal"> 
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="qa_title" class="control-label" >
                                제목</label>
                            <div class="input-icon right">
                                <input id="qa_title" name="qa_title" type="text" class="form-control" /></div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="qa_title" class="control-label" >
                                비밀번호</label>
                            <div class="input-icon right">
                                <input id="qa_pwd" name="qa_pwd" type="text" class="form-control" /></div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="qa_content" class="control-label">
                        내용</label><textarea id="qa_content" name="qa_content" rows="5" class="form-control"></textarea>
                </div>
            </div>
<!--            	<div class="form-group"> -->
<!-- 		<label class="control-label col-sm-2" for="file01">첨부파일1:</label> -->
<!-- 		<div class="col-sm-10"> -->
<!-- 			 <input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary"> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<div class="form-group"> -->
<!-- 		<label class="control-label col-sm-2" for="file02">첨부파일2:</label> -->
<!-- 		<div class="col-sm-10"> -->
<!-- 			 <input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary"> -->
<!-- 		</div> -->
<!-- 	</div>	 -->
            <div class="form-actions text-right pal">
                <button type="submit" class="btn btn-primary" id="insertBtn">등록</button>
                <button type="reset" class="btn btn-info" id="resetBtn">취소</button>
                <button type="button" class="btn btn-info" id="qnaListBtn">목록</button>
            </div>
            </form>
        </div>
</div>
</body>
<script type="text/javascript">

$(function(){
	$('#qnaListBtn').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/user/qna/qnaList.do');
	});
	
	$('#qnaForm').submit(function(){
		$(this).attr('action', '${pageContext.request.contextPath}/user/qna/insertQnaInfo.do');
		$(this).append('<input type="hidden" name="qa_mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
	});
});
</script>
</html>