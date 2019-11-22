<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#findid').click(function() {
			name = $('#inputName').val();
			bir = $('#inputBir').val();
			
			$.ajax({
				url : '${pageContext.request.contextPath}/user/member/findId.do',
				type : 'post',
				dataType : 'json',
				data : { 'name' : name, 'birth' : bir },
				error : function(xhr) {
					alert("status : " + xhr.status);
				},
				success : function(res) {
					$('#idres').text(res.mem_id);
				}
			});
		});
		
		$('#findpass').click(function() {
			id = $('#inputID').val();
			tel = $('#inputTel').val();
			name = $('#inputNAME').val();
			
			$.ajax({
				url : '${pageContext.request.contextPath}/user/member/findPass.do',
				type : 'post',
				dataType : 'json',
				data : { 'id' : id, 'tel' : tel, 'name' : name },
				error : function(xhr) {
					alert("status : " + xhr.status);
				},
				success : function(res) {
					$('#passres').text(res.mem_pass);
				}
			});
		});
		
		
	});
</script>
</head>
<body>                      
	<div class="panel panel-black">
	    <div class="panel-heading">아이디 찾기</div>
	    <div class="panel-body pan">
	        <form action="#" class="form-horizontal">
	        <div class="form-body pal">
	            <div class="form-group">
	                <label for="inputName" class="col-md-3 control-label">Name</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-user"></i>
	                        <input id="inputName" name="mem_name" type="text" placeholder="" class="form-control" />
	                	</div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label for="inputBir" class="col-md-3 control-label">Birth</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-lock"></i>
	                        <input id="inputBir" name="mem_birth" type="text" placeholder="1999-00-00" class="form-control" />
	                    </div>
	                    <span class="help-block mbn">고갱님의 아이디는&nbsp;&nbsp;<big style="color:red" id="idres"></big></span>
	                </div>
	            </div>
	        </div>
	        <div class="form-actions pal">
	            <div class="form-group mbn">
	                <div class="col-md-offset-3 col-md-6">
	                    <button type="button" class="btn btn-primary" id="findid">찾기</button>&nbsp;&nbsp;
	                    <button type="reset" class="btn btn-primary">취소</button>
	                </div>
	            </div>
	        </div>
	        </form>
	    </div>
	</div>
	<div class="panel panel-black">
	    <div class="panel-heading">비밀번호 찾기</div>
	    <div class="panel-body pan">
	        <form action="#" class="form-horizontal">
	        <div class="form-body pal">
	            <div class="form-group">
	                <label for="inputID" class="col-md-3 control-label">ID</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-user"></i>
	                        <input id="inputID" type="text" name="mem_id" placeholder="" class="form-control" />
	                	</div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label for="inputNAME" class="col-md-3 control-label">Name</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-user"></i>
	                        <input id="inputNAME" type="text" name="mem_name" placeholder="" class="form-control" />
	                	</div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label for="inputTel" class="col-md-3 control-label">Tel</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-user"></i>
	                        <input id="inputTel" name="mem_tel" type="text" placeholder="000-0000-0000" class="form-control" />
	                    </div>
	                    <span class="help-block mbn">고갱님의 비밀번호는&nbsp;&nbsp;<big style="color:red" id="passres"></big></span>
	                </div>
	            </div>
	        </div>
	        <div class="form-actions pal">
	            <div class="form-group mbn">
	                <div class="col-md-offset-3 col-md-6">
	                    <button type="button" class="btn btn-primary" id="findpass">찾기</button>&nbsp;&nbsp;
	                    <button type="reset" class="btn btn-primary">취소</button>
	                </div>
	            </div>
	        </div>
	        </form>
	    </div>
	</div>



</body>
</html>