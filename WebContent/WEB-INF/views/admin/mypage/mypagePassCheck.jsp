<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {

	});

</script>
</head>
<body>
	<ul class="nav nav-pills">
		<li class="active">
			<a href="${pageContext.request.contextPath }/admin/mypage/mypage.do">Profile</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/statistics.do">Statistics &nbsp;</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/admin/mypage/memberStatus.do">MemberStatus &nbsp;</a>
		</li>
	</ul>
	<div class="clearfix"></div>
	<div class="panel panel-black">
	    <div class="panel-heading">MyPage Pass Check</div>
	    <div class="panel-body pan">
	        <form action="${pageContext.request.contextPath}/admin/mypage/passCheck.do" method="post" class="form-horizontal">
	        <div class="form-body pal">
	            <div class="form-group">
	                <label for="inputPass" class="col-md-3 control-label">Password</label>
	                <div class="col-md-9">
	                    <div class="input-icon right">
	                        <i class="fa fa-lock"></i>
	                        <input id="inputPass" name="mem_pass" type="password" class="form-control" />
	                        <input id="myid" name="mem_id" value="${LOGIN_ADMININFO.mem_id }" type="hidden" />
	                	</div>
	                </div>
	            </div>
	        </div>
	        <div class="form-actions pal">
	            <div class="form-group mbn">
	                <div class="col-md-offset-3 col-md-6">
	                    <button type="submit" class="btn btn-primary" id="check">확인</button>&nbsp;&nbsp;
	                    <button type="reset" class="btn btn-primary">취소</button>
	                </div>
	            </div>
	        </div>
	        </form>
	    </div>
	</div>

</body>
</html>