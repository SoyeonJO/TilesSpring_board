<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$('#delete').submit(function() {
			var msglen = $('input[name=quit_mem_msg]').val().trim().length();
			if( msglen == 0 ) {
				alert("탈퇴 사유를 적어주세요.");
				return false;
			}
		});
		
		$('#list').click(function() {
			var url = "/admin/mypage/memberStatus.do";
			$(location).attr('href', url);
		});
	});
</script>
</head>
<body>
		<div class="col-md-9">
        <form action="${pageContext.request.contextPath}/admin/mypage/deleteMember.do"  class="form-horizontal">
        	<h3>계정 정보</h3>
            <div class="form-group"><label class="col-sm-3 control-label">이메일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_id }" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">이메일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_name }" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">닉네임</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_nick }" name="mem_nick" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">이메일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_mail }" name="mem_mail" placeholder="test@test.com" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <hr/>
            <h3>프로필 정보</h3>

            <div class="form-group"><label class="col-sm-3 control-label">생년월일</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="text" disabled="disabled" value="${memberInfo.mem_birth }" name="mem_birth" placeholder="0000-00-00" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">전화번호</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_tel }" placeholder="000-0000-0000" class="form-control"/></div>
                    </div>
                </div>
            </div>
             <div class="form-group"><label class="col-sm-3 control-label">우편번호</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-4"><input type="text" disabled="disabled" name="mem_zip" value="${memberInfo.mem_zip }" class="form-control"/></div>
                	</div>
            	</div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">주소</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_addr1 }" name="mem_addr1" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <div class="form-group"><label class="col-sm-3 control-label">상세 주소</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" disabled="disabled" value="${memberInfo.mem_addr2 }" name="mem_addr2" class="form-control"/></div>
                    </div>
                </div>
            </div>
            
            <div class="form-group"><label class="col-sm-3 control-label">탈퇴 사유</label>
                <div class="col-sm-9 controls">
                    <div class="row">
                        <div class="col-xs-9"><input type="text" value="" name="quit_mem_msg" class="form-control"/></div>
                    </div>
                </div>
            </div>
            <input name="quit_mem_star" value="1" type="hidden"/>
            <input name="quit_mem_id" value="${memberInfo.mem_id }" type="hidden"/>
            <input name="quit_mem_name" value="${memberInfo.mem_name }" type="hidden"/>
            <input name="quit_mem_tel" value="${memberInfo.mem_tel }" type="hidden"/>
            
            
            <hr/>
            <button type="button" id="list" class="btn btn-green">목록</button>
            <button type="submit" id="delete" class="btn btn-white" style="float:right">탈퇴</button>
        </form>
	</div>
	
</body>
</html>