<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/memberFormvalidation.js'> </script>
<script type="text/javascript">
	$(function() {
		$('#update').click(function() {
			if(!memberForm()) {
				return false;
			}
				
			datas = $('form').serializeArray();
			console.log(datas);
			$.ajax({
				url : '${pageContext.request.contextPath }/user/mypage/updateMember.do',
				type : 'post',
				dataType : 'json',
				data : datas,
				error : function(xhr) {
					alert("status : " + xhr.status);
				},
				success : function(res) {
					$('input[name=mem_mail]').val(res.mem_mail).text(res.mem_mail);
					$('input[name=mem_nick]').val(res.mem_nick).text(res.mem_nick);
					$('input[name=mem_pass]').val(res.mem_pass).text(res.mem_pass);
					$('input[name=mem_birth]').val(res.mem_birth).text(res.mem_birth);
					$('input[name=mem_tel]').val(res.mem_tel).text(res.mem_tel);
					$('input[name=mem_zip]').val(res.mem_zip).text(res.mem_zip);
					$('input[name=mem_addr1]').val(res.mem_addr1).text(res.mem_addr1);
					$('input[name=mem_addr2]').val(res.mem_addr2).text(res.mem_addr2);
				}
			});
		});
		
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
			
			$('input[name=mem_zip]').val(zipvalue).text(zipvalue);
			$('input[name=mem_addr1]').val(addrvalue).text(addrvalue);
			
			$('#dong').val('');
			$('#donglist').empty();
			$('#myModal').modal('hide');
		});
		
		
		$('#delete').click(function() {
			var url = '${pageContext.request.contextPath}/user/mypage/deletePage.do';
			$(location).attr('href', url);
		});
	});

</script>
</head>
<body>
	<ul class="nav nav-pills">
    	<li class="active">
    		<a href="${pageContext.request.contextPath }/user/mypage/mypage.do">Profile</a>
   		</li>
    	<li>
    		<a href="${pageContext.request.contextPath }/user/mypage/myBoardWritten.do">My board &nbsp;</a>
    	</li>
    </ul>
	<div class="clearfix"></div>
	<div class="col-md-9">
        <form action="#" class="form-horizontal"><h3>계정 정보</h3>
        	<input type="hidden" name="mem_id" value="${memberInfo.mem_id }"/>

            <div class="form-group"><label class="col-sm-3 control-label">이메일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="${memberInfo.mem_mail }" name="mem_mail" placeholder="test@test.com" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">닉네임</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="${memberInfo.mem_nick }" name="mem_nick" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">비밀번호</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="password" value="${memberInfo.mem_pass }" name="mem_pass" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">비밀번호 확인</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="password" name="mem_passchk" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <hr/>
            <h3>프로필 정보</h3>

            <div class="form-group"><label class="col-sm-3 control-label">생년월일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="text" value="${memberInfo.mem_birth }" name="mem_birth" placeholder="0000-00-00" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">전화번호</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="${memberInfo.mem_tel }" name="mem_tel" placeholder="000-0000-0000" class="form-control"/></div>
                    </div>
                </div>
            </div>
             <div class="form-group"><label class="col-sm-3 control-label">우편번호</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="text" name="mem_zip" value="${memberInfo.mem_zip }" class="form-control"/></div>
		                <div class="col-md-3">
			                <div class="input-icon right">
			                    <input id="zipSearch" type="button" value="우편번호찾기" class="form-control" data-toggle="modal" data-target="#myModal" /> 
			                </div>
                    	</div>
                	</div>
            	</div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">주소</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="${memberInfo.mem_addr1 }" name="mem_addr1" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">상세 주소</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="${memberInfo.mem_addr2 }" name="mem_addr2" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <hr/>
            <button type="button" id="update" class="btn btn-green">수정</button>
            <button type="reset" class="btn btn-red">취소</button>
            <button type="button" id="delete" class="btn btn-white" style="float:right">탈퇴</button>
        </form>
	</div>
	
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