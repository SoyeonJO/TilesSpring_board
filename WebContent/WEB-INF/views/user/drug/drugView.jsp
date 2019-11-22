<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		item_seq = '${param.item_seq}';
		datas = '';
		
		$.ajax({
			url : '/user/drug/drugInfo.do',
			type : 'get',
			dataType: 'xml',
			data : { 'item_seq' : item_seq },
			success : function(res){
				$(res).find("item").each(function(){
					seq = $(this).find("ITEM_SEQ").text();
					item_name = $(this).find("ITEM_NAME").text();
					entp_seq = $(this).find("ENTP_SEQ").text();
					entp_name = $(this).find("ENTP_NAME").text();
					color_class = $(this).find("COLOR_CLASS1").text();
					line_front = $(this).find("LINE_FRONT").text();
					class_name = $(this).find("CLASS_NAME").text();
					etc_otc_name = $(this).find("ETC_OTC_NAME").text();
					chart = $(this).find("CHART").text();
					drug_shape = $(this).find("DRUG_SHAPE").text();
					item_permit_date = $(this).find("ITEM_PERMIT_DATE").text();
					image = $(this).find("ITEM_IMAGE").text();
					if(!line_front){
						line_front = "없음";
					}
					
					$('input[name=md_ct_seq]').val(seq);
					$('input[name=md_ct_name]').val(item_name);
					$('input[name=entp_seq]').val(entp_seq);
					$('input[name=md_ct_entname]').val(entp_name);
					$('input[name=md_ct_color]').val(color_class);
					$('input[name=md_ct_line]').val(line_front);
					$('input[name=class_name]').val(class_name);
					$('input[name=etc_otc_name]').val(etc_otc_name);
					$('#chart').val(chart);
					$('input[name=md_ct_chart]').val(chart);
					$('input[name=md_ct_shape]').val(drug_shape);
					$('input[name=item_permit_date]').val(item_permit_date);
					$('input[name=md_ct_image]').val(image);
					
					datas = $('#ff').serializeArray();
					console.log(datas);
					
					$.ajax({
						url : '/user/drug/saveDrugInfo.do',
						type : 'post',
						data : datas,
						success : function(res){
						},
						error : function(res){
							alert('안됨 ㅋ2.');
						}
					});
					
				});
			},
			error : function(res){
				alert('안됨 ㅋ.');
			}
		});
		
		$('#listBtn').click(function(){
			$(location).attr('href', '/user/drug/searchDrugName.do');
		});
	});
</script>
<style type="text/css">
	#d1{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="panel panel-green">
		<div class="panel-heading">약 상세정보 보기</div>
		<div class="panel-body pan">
			<form id="ff" action="#">
				<div class="form-body pal">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									품목일련번호
									<i class="fa fa-user"></i> <input id="item_seq" name="md_ct_seq" type="text" class="form-control" disabled="disabled"/>
									<input id="item_seq" name="md_ct_seq" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									품목명
									<i class="fa fa-user"></i> <input id="item_name" name="md_ct_name" disabled="disabled" type="text"class="form-control" />
									<input id="item_name" name="md_ct_name" type="hidden" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									업체일련번호
									<i class="fa fa-user"></i> <input id="entp_seq" name="entp_seq" disabled="disabled" type="text" class="form-control" />
									<input id="entp_seq" name="entp_seq" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									업체명
									<i class="fa fa-user"></i> <input id="entp_name" name="md_ct_entname" type="text" disabled="disabled" class="form-control" />
									<input id="entp_name" name="md_ct_entname" type="hidden" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									분류명
									<i class="fa fa-user"></i> <input id="class_name" name="class_name" disabled="disabled" type="text" class="form-control" />
									<input id="class_name" name="class_name" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									전문/일반
									<i class="fa fa-user"></i> <input id="etc_otc_name" name="etc_otc_name" type="text" disabled="disabled" class="form-control" />
									<input id="etc_otc_name" name="etc_otc_name" type="hidden" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									색깔
									<i class="fa fa-user"></i> <input id="color_class" name="md_ct_color" disabled="disabled" type="text" class="form-control" />
									<input id="color_class" name="md_ct_color" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									모양
									<i class="fa fa-user"></i> <input id="drug_shape" name="md_ct_shape" disabled="disabled" type="text" class="form-control" />
									<input id="drug_shape" name="md_ct_shape" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									분할선
									<i class="fa fa-user"></i> <input id="line_front" name="md_ct_line" type="text" disabled="disabled" class="form-control" />
									<input id="line_front" name="md_ct_line" type="hidden" value=""/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<div class="input-icon">
									품목허가일자
									<i class="fa fa-user"></i> <input id="item_permit_date" name="item_permit_date" type="text" disabled="disabled" class="form-control" />
									<input id="item_permit_date" name="item_permit_date" type="hidden" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						성상
						<textarea rows="5" id="chart" name="md_ct_chart" disabled="disabled" class="form-control"></textarea>
						<input id="chart" name="md_ct_chart" type="hidden" value=""/>
					</div>
					<input type="hidden" id="md_ct_image" name="md_ct_image" value=""/>
				<div id="d1" class="form-actions text-right pal">
					<button id="listBtn" type="button" class="btn btn-primary">목록</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>