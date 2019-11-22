<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ef8e23d5375aba4213367dd26062129f"></script>
<style type="text/css">
	#d1{
		text-align: center;
	}
	#map{
		margin: auto;
	}
</style>
</head>
<body>
	<form action="">
		
		<br>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<select id="sido"  class="form-control">
						<option value="" selected="selected" disabled="disabled">시·도</option>
						<option value="서울특별시">서울특별시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="인천광역시">인천광역시</option>
						<option value="광주광역시">광주광역시</option>
						<option value="경상남도">경상남도</option>
						<option value="경상북도">경상북도</option>
						<option value="전라남도">전라남도</option>
						<option value="전라북도">전라북도</option>
						<option value="충청남도">충청남도</option>
						<option value="충청북도">충청북도</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="제주특별자치도">제주특별자치도</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<select id="gugun" class="form-control">
						<option value="" selected="selected" disabled="disabled">구·군</option>
					</select>
				</div>
			</div>
		</div>	
		<br>
		<div id="map" style="width:500px;height:400px;"></div>
		<br>
		<div class="panel panel-green">
        	<div class="panel-heading">병·의원 정보 목록</div>
			<div class="panel-body">
				<table id="itemList" class="table table-hover-color">
					<thead>
						<tr>
							<th>기관명</th>
							<th>기관구분</th>
							<th>주소</th>
						</tr>
					</thead>
					<tbody id="body">
						
					</tbody>
				</table>
			</div>
		</div>
		
	</form>
</body>
<script type="text/javascript">
	$(function(){
		var wgs84Lon = "";
    	var	wgs84Lat = "";
    	
    	var options = "";
    	var markerPosition = "";
    	
    	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		
		$.ajax({
			url : '/user/hospital/getSido.do',
			dataType : 'xml',
			type : 'get',
			success : function(res){
				code = "";
				
				$(res).find("item").each(function(){
					code += "<tr class='hospitaltr'>";
					code +="	<td>"+ $(this).find("dutyName").text() +"</td>";
					code +="	<td>"+ $(this).find("dutyDivNam").text() +"</td>";
					code +="	<td>"+ $(this).find("dutyAddr").text() +"</td>";
					code +="<input class='lon' type='hidden' value='" + $(this).find("wgs84Lon").text() + "'/>";
					code +="<input class='lat' type='hidden' value='" + $(this).find("wgs84Lat").text() + "'/>";
					code +="</tr>";
					
				});
				
				$('#body').html(code);
			},
			error : function(res){
				alert('안됨 ㅋ1.');
			}
		});
		
		$('#sido').change(function(){
			sido = $(this).val();
			
			$.ajax({
				url : '/user/hospital/getGugun.do',
				dataType : 'xml',
				type : 'get',
				data : { 'sido' : sido },
				success : function(res){
					code = "<option value='' selected disabled>구·군</option>";
					
					$(res).find("item").each(function(){
						gugun = $(this).find("dutyAddr").text().split(" ")[1];
						
						code += "<option value='" + gugun + "'>" + gugun + "</td>";
					});
					
					$('#gugun').html(code);
					$('#gugun').trigger('change');
				},
				erroe : function(res){
					alert('안됨 ㅋ.');
				}
			});
		});
		
		$('#gugun').change(function(){
			sido = $('#sido option:selected').val();
			gugun = $(this).val();
			
			$.ajax({
				url : '/user/hospital/getGubun.do',
				dataType : 'xml',
				type : 'get',
				data : { 'sido' : sido,
						 'gugun' : gugun },
				success : function(res){
					code = "";
					
					$(res).find("item").each(function(){
						code += "<tr class='hospitaltr'>";
						code +="	<td>"+ $(this).find("dutyName").text() +"</td>";
						code +="	<td>"+ $(this).find("dutyDivNam").text() +"</td>";
						code +="	<td>"+ $(this).find("dutyAddr").text() +"</td>";
						code +="<input class='lon' type='hidden' value='" + $(this).find("wgs84Lon").text() + "'/>";
						code +="<input class='lat' type='hidden' value='" + $(this).find("wgs84Lat").text() + "'/>";
						code +="</tr>";
					});
					
					$('#body').html(code);
				},
				error : function(res){
					alert('안됨 ㅋ.');
				}
			});
		});
		
		
		$('#body').on('click', '.hospitaltr', function(){
			wgs84Lon = $(this).find('.lon').val();
			wgs84Lat = $(this).find('.lat').val();
			name = $(this).find('td:eq(0)').text();
			
			options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(wgs84Lat, wgs84Lon), //지도의 중심좌표.
				level: 3 //지도의 레벨(확대, 축소 정도)
			};
				
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
				
			// 마커가 표시될 위치입니다 
			markerPosition  = new kakao.maps.LatLng(wgs84Lat, wgs84Lon); 
				
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: markerPosition
			});
				
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			
			var iwContent = '<div style="padding:5px; color:blue; font-size:15px; font-weight:bold; text-align:center;">' + name + ' </div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	   		 iwPosition = new kakao.maps.LatLng(wgs84Lat, wgs84Lon); //인포윈도우 표시 위치입니다

			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
		   	 	position : iwPosition, 
		    	content : iwContent 
			});
		   		 
			// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
			infowindow.open(map, marker); 
		});
	});
</script>
</html>