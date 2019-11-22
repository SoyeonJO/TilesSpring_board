package kr.or.ddit.user.freeboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.fileitem.service.IfileItemService;
import kr.or.ddit.user.fileitem.service.IfileItemServiceImpl;
import kr.or.ddit.vo.FileItemVO;

public class FreeboardFileAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		String fileSEQ = request.getParameter("fileSEQ");  //첨부파일번호 받아오기
		String bo_no =request.getParameter("bo_no");  //게시글번호 받아오기 (첨부파일을 받은 해당 게시물로 다시 돌아가야하니까)
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("file_seq", fileSEQ);

		IfileItemService service = IfileItemServiceImpl.getInstance(); 
		FileItemVO fileItemInfo = service.fileInfo(params);

		File downloadFile = new File(GlobalConstant.FILE_PATH, fileItemInfo.getFile_save_name());
		
		if(downloadFile.exists()){
			// 브라우저의 다운로드(ISO-8859-1) 창 대상 설정 
			//    다운로드 파일명
			//    파일 사이즈
			//    파일 설명
			String fileName = null;
			try {
				fileName = URLEncoder.encode(fileItemInfo.getFile_name(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			response.setContentType("application/octet-stream");
			response.setContentLength((int)downloadFile.length());
			
	
		
	
			// 다운로드 대상 파일의 컨텐츠를 읽고, 브라우저 대상 쓰기
			byte[] buffer = new byte[(int)downloadFile.length()];
			
			BufferedInputStream inputStream = null;
			try {
				inputStream = new BufferedInputStream(new FileInputStream(downloadFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedOutputStream outputStream = null;
			try {
				outputStream = new BufferedOutputStream(
						                                 response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int readCNT = 0;
			try {
				while((readCNT = inputStream.read(buffer)) != -1){
					outputStream.write(buffer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	      // return 경로는 사진을 업로드해온 해당 게시글 bo_no으로  
		//return "/user/freeboard/freeboardView.do?bo_no="+ bo_no;
		return null;

	}
      

}
