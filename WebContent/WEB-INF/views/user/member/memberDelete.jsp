<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('.rating i').click(function(){
			  $(this).parent().children('i').removeClass('text-yellow');
			  $(this).addClass('text-yellow').prevAll('.fa-star').addClass('text-yellow');
			  var num = $(this).attr('id');
			  $('#star').text(num);
			  $('#inputstar').val(num);
			  return false;
		});
		
		$('.rating i').on('change', 'i', function() {
			var num = $(this).attr('id');
			
			$('#star').text(num);
			$('#inputstar').val(num);
		});
		
		$('#withdraw').click(function() {
			msgvalue = $('#mem_msg').val();
			msglen = msgvalue.trim().length;
			if( msglen <= 0 ) {
				alert("탈퇴 사유를 적어주세요.");
				return false;
			}
			
			passvalue = $('#mem_pass').val();
			passckvalue = $('#mem_passCheck').val();
			if(passvalue != passckvalue) {
				alert("비밀번호를 다시 확인해주세요.");
				return false;
			}
			
			starvalue = $('#inputstar').val();
			starlen = starvalue.trim().length;
			if(starlen <= 0) {
				alert("별점을 입력해주세요.");
				return false;
			}
		});
		
	});

</script>
</head>
<body>
	<div class="panel panel-pink">
	    <div class="panel-heading">Delete Account form</div>
	    <div class="panel-body pan">
	        <form action="${pageContext.request.contextPath }/user/member/deleteMember.do">
	        <div class="form-body pal">
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input type="hidden" name="quit_mem_id" value="${LOGIN_MEMBERINFO.mem_id }" />
	                    <input id="inputName" type="text" placeholder="이름" class="form-control" name="quit_mem_name" value="${LOGIN_MEMBERINFO.mem_name }"/>
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-user"></i>
	                    <input id="inputName" type="text" placeholder="000-0000-0000" class="form-control" name="quit_mem_tel" value="${LOGIN_MEMBERINFO.mem_tel }"/>
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="input-icon right">
	                    <i class="fa fa-lock"></i>
	                    <input type="hidden" id="mem_pass" value="${LOGIN_MEMBERINFO.mem_pass }" />
	                    <input id="inputpass" type="text" class="form-control" id="mem_passCheck" value=""/>
	                </div>
	            </div>
	            <div class="form-group">
	                <textarea rows="5" id="mem_msg" placeholder="탈퇴 이유를 적어주세요." name="quit_mem_msg" class="form-control"></textarea>
	            </div>
	            <div class="form-group">
	                <div class="rating">
	                	사이트에 대한 별점을 매겨 주세요! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i class="fa fa-star" id="1"></i>
                        <i class="fa fa-star" id="2"></i>
                        <i class="fa fa-star" id="3"></i>
                        <i class="fa fa-star" id="4"></i>
                        <i class="fa fa-star" id="5"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span id="star" style="color:red" name="quit_mem_star"></span>
                        <input type="hidden" id="inputstar" name="quit_mem_star"/>
	                </div>
	            </div>
	        </div>
	        <div class="form-actions text-right pal">
	            <button type="submit" class="btn btn-primary" id="withdraw">탈퇴</button>
	        </div>
	        </form>
	    </div>
	</div>

</body>
</html>