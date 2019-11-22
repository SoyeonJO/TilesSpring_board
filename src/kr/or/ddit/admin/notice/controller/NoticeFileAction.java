package kr.or.ddit.admin.notice.controller;

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
import kr.or.ddit.admin.noticeitem.service.INoticeItemService;
import kr.or.ddit.admin.noticeitem.service.INoticeItemServiceImpl;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.NoticeItemVO;

public class NoticeFileAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String fileSEQ = request.getParameter("fileSEQ");
		String notice_no = request.getParameter("notice_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("fi_not_seq"	, fileSEQ);
		
		INoticeItemService service = INoticeItemServiceImpl.getInstance();
		NoticeItemVO fileItemInfo = service.noticeItemInfo(params);
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileItemInfo.getFi_not_save_name());
		
		
		if(downloadFile.exists()){
			
			String fileName = null;
			try{
				fileName = URLEncoder.encode(fileItemInfo.getFi_not_name(), "UTF-8");
			}catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
			
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			response.setContentType("application/octet-stream");
			response.setContentLength((int)downloadFile.length());
			
			byte[] buffer = new byte[(int)downloadFile.length()];
			
			BufferedInputStream inputStream = null;
			try{
				inputStream = new BufferedInputStream(new FileInputStream(downloadFile));
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			BufferedOutputStream outputStream = null;
			try{
				outputStream = new BufferedOutputStream(response.getOutputStream());
			}catch(IOException e){
				e.printStackTrace();
			}
			int readCNT = 0;
			try{
				while((readCNT = inputStream.read(buffer)) != -1){
					outputStream.write(buffer);
				}
			}catch(IOException e){
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
		return "/admin/notice/noticeView.do?notice_no="+ notice_no;

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	


