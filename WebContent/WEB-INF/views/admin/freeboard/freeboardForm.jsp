<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div class="panel panel-green">
		<div class="panel-heading">자유 게시판</div>
		<div class="panel-body pan">
		
		
		<form action="#"  id ="regibtn"  method="POST"  enctype="multipart/form-data">
					<div class="form-body pal">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">

								<label for="inputName" class="control-label"> Name</label>
									<div class="input-icon right">
										<i class="fa fa-user"></i> <input id="bo_nickname" name ="bo_nickname" type="text" placeholder="" class="form-control" />
									</div>

								<label for="inputEmail" class="control-label"> E-mail</label>
									<div class="input-icon right">
										<i class="fa fa-envelope"></i> <input id="bo_mail" name ="bo_mail" type="text" placeholder="" class="form-control" />
									</div>

                                <label for="inputPassword" class="control-label"> Password</label>
            
                                   <div class="input-icon right">
                                        <i class="fa fa-lock"></i><input id="bo_pwd" type="text " name ="bo_pwd" placeholder="숫자4자리" class="form-control" /></div>
                                   </div>
                           </div>  
                           </div>  
                 
                     
                     
                     
              
             <div class="form-group"> 
	           <div class="col-md-7">
						<label class="control-label col-sm-2" for="file01">FILE1:</label>
						<div class="col-sm-5">
							<input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
						</div>
					</div>
					<div class="col-md-7">
						<label class="control-label col-sm-2" for="file02">FILE2:</label>
						<div class="col-sm-10">
							<input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
						</div>
					</div>
		        </div>
 			</div>
 
 
  </div>  
  
				<div class="form-group">
						<label for="inputSubject" class="control-label col-sm-2">Title</label>
						<div class="input-icon right">
							<i class="fa fa-tag"></i> <input id="bo_title" name ="bo_title"  type="text" placeholder="" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputMessage" class="control-label col-sm-2">Content</label>
						<textarea id = "bo_content" rows="10" name ="bo_content"  class="form-control"></textarea>
						
</div>
</div>
			<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info" style="float: right" >등록</button>
				<button type="reset" class="btn btn-danger" style="float: right" >취소</button>
				<button type="button" class="btn btn-primary" style="float: right" id="listbtn">목록</button>
			</div>
		</div>
				</div>

			</form>
	
</body>
<script type="text/javascript" src='/js/freevalidation.js'></script>
<script type = "text/javascript">

$(function(){
	
	$('form').submit(function(){
		if(!$('#bo_nickname').val().validationNAME()){
			alert('이름을 바르게 입력해주세요.');
			return false;
		}
		if(!$('#bo_mail').val().validationEMAIL()){
			alert('이메일 주소를 바르게 입력해주세요.');
			return false;
		}
		if(!$('#bo_pwd').val().validationPASSWORD()){
			alert('비밀번호를 숫자 4자리로 입력해주세요.');
			return false;
		}
		if(!$('#bo_title').val().validationTITLE()){
			alert('제목을 입력해주세요.');
			return false;
		}
		if(!$('#bo_content').val().validationCONTENT()){
			alert('내용을 입력해주세요.');
			return false;
		}
	
	
	});
	
	
	
	
	
	
	
	$('#listbtn').click(function(){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/freeboard/freeboardList.do');
		});
	
	$('#regibtn').submit(function(){
	
		$(this).attr('action', '${pageContext.request.contextPath}/admin/freeboard/insertBoardInfo.do');
		$(this).append('<input type="hidden" name="bo_mem_id" value="${LOGIN_ADMININFO.mem_id}"></input>');
		
		});


	
	});
</script>

</html>