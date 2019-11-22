<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/xml2json.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.xdomainajax.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : '/user/drug/drugName.do',
			type : 'get',
			dataType : 'xml',
			success : function(res){
				code = "";
				
				$(res).find("item").each(function(){
					code += "<tr class='drugtr'>";
					code += "	<td>" + $(this).find("ITEM_SEQ").text() + "</td>";
					code += "	<td><img class='dimage' src='" + $(this).find("ITEM_IMAGE").text() + "'/></td>";
					code += "	<td>" + $(this).find("ITEM_NAME").text() + "</td>";
					code += "	<td>" + $(this).find("ENTP_NAME").text() + "</td>";
					code += "</tr>";
				});
				
				$('#body').html(code);
			},
			error : function(callback){
				alert('안됨ㅋ.');
			}
		});
		
		
		$('#searchDrug').click(function(){
			var drugName = $('#drugName').val();
			
			$.ajax({
				url : '/user/drug/drugName.do',
				type : 'get',
				dataType : 'xml',
				data : { 'drugName' : drugName },
				success : function(res){
					var total = $(res).find("totalCount").text();
					code = "";
					
					if(total == "0"){
						code += "<tr>";
						code += "	<td colspan='4'><span class='a'>검색된 데이터가 없습니다.</span></td>";
						code += "</tr>";
					}else{
						$(res).find("item").each(function(){
							
							code += "<tr class='drugtr'>";
							code += "	<td>" + $(this).find("ITEM_SEQ").text() + "</td>";
							code += "	<td><img class='dimage' src='" + $(this).find("ITEM_IMAGE").text() + "'/></td>";
							code += "	<td>" + $(this).find("ITEM_NAME").text() + "</td>";
							code += "	<td>" + $(this).find("ENTP_NAME").text() + "</td>";
							code += "</tr>";
						});
					}
					
					$('#body').html(code);
				},
				error : function(callback){
					alert('안됨ㅋ.');
				}
			});
		});
		
		$('#itemList').on('click', '.drugtr', function(){
			itemSeq = $('td:eq(0)', this).text();
			
			$(location).attr('href', '/user/drug/drugView.do?item_seq=' + itemSeq);
		});
	});
</script>
<style type="text/css">
	.a{
		color : red;
		font-size : 20px;
		font-weight: bold;
	}
	.dimage{
		width : 200px;
		height : 100px;
	}
</style>
</head>
<body>
	<form action="">
		<div class="input-group">
			<input id="drugName" type="text" class="form-control"/>
			<span class="input-group-btn">
				<button id="searchDrug" type="button" class="btn btn-default">검색</button>
			</span>
		</div>
		<br>
		<div class="panel panel-green">
        	<div class="panel-heading">알약 검색 결과</div>
			<div class="panel-body">
				<table id="itemList" class="table table-hover-color">
					<thead>
						<tr>
							<th>품목일련번호</th>
							<th>제품이미지</th>
							<th>품목명</th>
							<th>업체명</th>
						</tr>
					</thead>
					<tbody id="body">
					
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>