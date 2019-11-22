<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.ziptr:hover {
		background : lightgrey;
	}
</style>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/memberFormvalidation.js'> </script>
<script type='text/javascript'>
$(function(){
	$('#zipbtn').click(function() {
		dongvalue = $('#dong').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/member/zipcodeSearchForm.do',
			type : 'post',
			dataType : 'json',
			data : { 'dong' : dongvalue },
			error : function(xhr) {
				alert("status : " + xhr.status);
			},
			success : function(res) {
				code = "<table>";
				code += "<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>";
				$.each(res, function(i) {
					code += "<tr class='ziptr'><td>" + res[i].zipcode + "</td><td>" + res[i].sido + " " + res[i].gugun + " " + res[i].dong + "</td><td>" + res[i].bunji + "</td></tr>";
				});
				code += "</table>";
				$('#donglist').html(code);
			}
		});
	});
	
	$('#donglist').on('click', 'tr:gt(0)', function() {
		zipvalue = $(this).find('td:eq(0)').text();
		addrvalue = $(this).find('td:eq(1)').text();
		
		$('#mem_zip').val(zipvalue).text(zipvalue);
		$('#mem_addr1').val(addrvalue).text(addrvalue);
		
		$('#myModal').modal('hide');
		$('#dong').val('');
		$('#donglist').empty();
	});
	
	$('#idcheck').click(function() {
		memid = $('#mem_id').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/member/idCheck.do',
			type : 'post',
			dataType : 'json',
			data : {'memid' : memid },
			error : function(xhr) {
				alert("status : " + xhr.status);
			},
			success : function(res) {
				if(eval(res.flag)) {  // true
					$('#result').text("사용 가능한 아이디입니다.");
				}else {
					$('#result').text("사용 불가능한 아이디입니다.");
				}
			}
		});
	});
	
	$('#checkin').click(function() {
		if(!memberForm()) {
			return false;
		}
	});
	
});

</script>
</head>
<style>
	.fieldName {text-align: center; background-color: #f4f4f4;}
	.tLine {background-color: #d2d2d2; height: 1px;}
	.btnGroup { text-align: right; }
	td {text-align: left; }
</style>
<body>
http://192.168.207.141/user/member/memberForm.do
<form name="memberForm" method="POST" action="${pageContext.request.contextPath }/user/member/insertMemberInfo.do">
<div class="panel panel-black">
	<div class="panel-heading">회원 가입</div>
	    <div class="panel-body pan">
	        <form action="#">
	        <div class="form-body pal">
	        	<div class="row">
		            <div class="col-md-4">
		                <div class="input-icon right">
		                    <i class="fa fa-user"></i>
		                    <input id="mem_id" name="mem_id" type="text" placeholder="아이디" class="form-control" />
		                </div>
		            </div>
		            <div class="col-md-2">
		                <div class="input-icon right">
		                    <input id="idcheck" type="button" value="아이디 중복 체크" class="form-control"/> 
		                </div>
	            	</div>
                    <span id="result" style="color:red"></span> 
		        </div> 
		        <br>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="mem_name" name="mem_name" type="text" placeholder="이름" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-lock"></i>
	                    <input id="mem_pass" name="mem_pass" type="password" placeholder="비밀번호" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-lock"></i>
	                    <input id="mem_passChk" type="password" placeholder="비밀번호 확인" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="mem_nick" name="mem_nick" type="text" placeholder="닉네임" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="mem_mail" name="mem_mail" type="text" placeholder="이메일 : test@test.com" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="mem_birth" name="mem_birth" type="text" placeholder="생년월일 : 1999-01-01" class="form-control" /></div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="mem_tel" name="mem_tel" type="text" placeholder="전화번호 : 010-0000-0000" class="form-control" /></div>
	            </div>
	            <hr />
	            <div class="row">
		            <div class="col-md-4">
		                <div class="input-icon right">
		                    <i class="fa fa-envelope"></i>
		                    <input id="mem_zip" name="mem_zip" type="text" placeholder="우편번호" class="form-control" onclick="javascript:zipSearch();" /> 
		                </div>
		            </div>
		            <div class="col-md-2">
		                <div class="input-icon right">
		                    <input id="zipSearch" type="button" value="우편번호찾기" class="form-control" data-toggle="modal" data-target="#myModal" /> 
		                </div>
		            </div>
	            </div>
	            <br>
	            <div class="row">
	                <div class="col-md-4">
	                    <div class="form-group">
	                        <input id="mem_addr1" name="mem_addr1" type="text" placeholder="주소" class="form-control" /></div>
	                </div>
	                <div class="col-md-8">
	                    <div class="form-group">
	                        <input id="mem_addr2" name="mem_addr2" type="text" placeholder="상세주소" class="form-control" />
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="form-actions text-right pal">
	            <button type="submit" class="btn btn-primary" id="checkin">회원가입</button>
	            <button type="reset" class="btn btn-error">취소</button>
	        </div>
	        </form>
	    </div>
	</div>
</form>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">우편번호검색</h4>
				</div>
				<div class="modal-body">
					<input type="text" id="dong" placeholder="동 입력" class="form-control">
					<button type="button" id="zipbtn" class="btn btn-primary" style="float:right">검색</button>
					
					<br><br>
					<div id="donglist"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
  	</div>
</body>
</html>








