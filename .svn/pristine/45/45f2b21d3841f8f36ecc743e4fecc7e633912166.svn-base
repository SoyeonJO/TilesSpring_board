<%@page import="kr.or.ddit.global.GlobalConstant"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//업로드 처리된 파일을 db에 바이너리 코드로 저장X
//ex> 1G파일 업로드=> DB에 특정 테이블의 특정 컬럼(BLOB Type)에 저장 
//    저장 
//특정 위치에 파일을 저장, 파일 정보는 DB에 저장(FILEITEM테이블)
//


 //application.getRealPath는 D:\A_TeachingMaterial\7.JspSpring\workspace\ddit\업로드  까지 접근
//이미지를 저장 할수있는 폴더접근까지만듬
//    String savePath= application.getRealPath("upload");

      String savePath = GlobalConstant.FILE_PATH;


// 서버에 전송될 파일(임시저장소, 실제저장소 구분저장처리)
//    * 사이즈 제한(파일 단위의 사이즈 제한, 전체 파일의 사이즈제한)
     int fileSizeMax = 1024*1024*100; 

//클라이언트 서버 대상 요청
// 일반요청 : 
	//       contentType =null(request.getContextType())
//             직접 주소 입력
//             location.href = 주소(히스토리 저장), 
// 			   location.replace(주소)-히스토리 저장 X
//             <a href= 주소> 텍스트 <a>
//          ajax 
//          contentType = application/X-www-form-urlencoded
//               <form method= get|post/>
//               ajax({contentType: application/x-www-form-urlencoded})
//          파일 업로드 요청
//          contentType = multipart/form-data(request.getContentType())
//                <form method=POST enctype =multupart/form-data/>
//                 ajax()
// 클라이언트의 요청이 파일업로드 요청 여부 확인 
// multipartFlag true= contentType(multipart/ form-data)
//               false = 일반요청
  boolean multipartFlag=  ServletFileUpload.isMultipartContent(request);
	
		if(multipartFlag){
	  //클라이언트가 서버대상으로 파일을 업로드할 때
	  //  1.서버가 관리하는 임시저장소에 (서버 내 서버가 관리[파일단위|메모리]) 
	  //     1.1 임시저장소에 저장된 파일의 확장자: *.tmp
	  //     1.2 임시저장소 개발자에 의해서 재정의 될 수 있다: 파일단위 임시저장소의 경로 재설정
	  //       												임시저장소에 저장될 파일 사이즈 (파일별 , 전체파일)
	  //   2. 서버 내 실제 저장소(개발자)
	  //      2.1 임시저장소에 저장된 파일을 기저로 실제 저장소에 해당파일을 저장 처리
	  //    2.2 실제 파일 저장시 임시저장소의 해당 파일은 삭제
	   
	   // 임시저장소 설정
		    DiskFileItemFactory factory = new DiskFileItemFactory();
	 
	   factory.setSizeThreshold(fileSizeMax);
		  
		  //실제 저장소 설정  및 업로드된 컨텐츠(mem_id, mem_pass, mem_name , files*2)
	ServletFileUpload fileUpload = new ServletFileUpload(factory);
	      // 업로드된 파일단위의 사이즈제한 
	   fileUpload.setFileSizeMax(fileSizeMax);
	      // 업로드된 전체파일의 사이즈제한 
		    //   default: -1(사이즈 제한없음)
	    fileUpload.setFileSizeMax(fileSizeMax);
	       
	       //업로드 컨텐츠 
	        //      폼필드(FileItem): mem_id, mem_pass, mem_name
	  		//        파일(FileItem): files*2
	    List<FileItem> items = fileUpload.parseRequest(request);
	       
	       for(FileItem item: items){
	    	   //isFormField() true: mem_id, mem_pass, mem_pass 
	    	               //  false: files*2    
		    	   if(item.isFormField()){  //취득하기
		              out.println(item.getFieldName()+"|"+ item.getString("UTF-8")+"<br/>");
		    	   
		    	   }else{
		    		   
		    		   if(item.getSize() >0){
		    		   //업로드된 파일정보 취득
		    		   out.println("name(fieldname):"+ item.getFieldName()+ "| filename" + item.getName()+ " | content-type:" + item.getContentType()+ " | size: "+ item.getSize()+"<br/>"); 
		    		   // D:\\temp\\a.png or a.png
		    		   // => a.png
		    		   String fileName = FilenameUtils.getName(item.getName());
		    	        
			    		   //다운로드*
			    		    pageContext.setAttribute("fileName", fileName);
			    		   
		    		   // 0size 파일이 생성 
		    		   File saveFile = new File(savePath, fileName);
		    	       item.write(saveFile);
	    	  
		    		   }
		    		   }
	       }
  
  }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<img src="/files/${pageScope.fileName}" alt="" width="100px" height="120px"
     onclick="javascript:fileDownload();"/>

</body>
<script type='text/javascript'>
  function fileDownload(){
	  
	  //영어파일명.png or 한글파일명.png
	  // http://domain/ddit/14/fileDownload.jsp?fileName= 한글파일명.jsp
	var fileName = encodeURIComponent('${fileName}');
    location.href = '${pageContext.request.contextPath}/admin/fileitem/fileDownload.jsp?fileName=' + fileName;
	
  }

</script>
</html>