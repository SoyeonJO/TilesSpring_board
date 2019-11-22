<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" data-step="2"
	data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
	data-position="right" class="navbar-default navbar-static-side">
	<div class="sidebar-collapse menu-scroll">
		<ul id="side-menu" class="nav">
			<div class="clearfix"></div>
			<li >
				<a href="/user/drug/searchDrugName.do">
					<i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i>
					<span class="menu-title">알약 검색</span>
				</a>
			</li>
			<li>
				<a href="/user/drugstore/drugStoreMain.do">
					<i class="fa fa-desktop fa-fw"><div class="icon-bg bg-pink"></div></i>
					<span class="menu-title">약국 검색</span>
				</a>
			</li>
			<li>
				<a href="/user/hospital/hospitalMain.do">
					<i class="fa fa-send-o fa-fw"><div class="icon-bg bg-green"></div></i>
					<span class="menu-title">병원 검색</span>
				</a>
			</li>
			<li>
				<a href="/user/notice/noticeList.do">
					<i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet"></div></i>
					<span class="menu-title">공지사항</span>
				</a>
			</li>
			<li>
				<a href="/user/freeboard/freeboardList.do">
					<i class="fa fa-th-list fa-fw"><div class="icon-bg bg-blue"></div></i>
					<span class="menu-title">자유게시판</span>
				</a>
			</li>
			<li>
				<a href="/user/qna/qnaList.do">
					<i class="fa fa-database fa-fw"><div class="icon-bg bg-red"></div></i>
					<span class="menu-title">Q&A</span>
				</a>
			</li> 
			<li>
				<a href="/user/news/newsList.do">
					<i class="fa fa-file-o fa-fw"><div class="icon-bg bg-yellow"></div></i>
					<span class="menu-title">보도자료</span>
				</a>
			</li> 
			<c:if test="${!empty LOGIN_MEMBERINFO }">
				<li>
					<a href="${pageContext.request.contextPath }/user/mypage/mypage.do">
						<i class="fa fa-file-o fa-fw"><div class="icon-bg bg-lime"></div></i>
						<span class="menu-title">마이페이지</span>
					</a>
				</li>
			 </c:if>
			 <c:if test="${empty LOGIN_MEMBERINFO }">
			 
			 </c:if>
		</ul>
	</div>
</nav>
</body>
</html>