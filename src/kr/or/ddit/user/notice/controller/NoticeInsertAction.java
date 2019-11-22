package kr.or.ddit.user.notice.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.NoticeVO;

public class NoticeInsertAction implements IAction {
	private boolean Flag = false;
	
	@Override
	public boolean isRedirect() {
		return Flag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper) request;
		
		NoticeVO noticeInfo = new NoticeVO();
		
		try {
			BeanUtils.populate(noticeInfo, wrapper.getParameterMap());
			
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=UTF-8");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		INoticeService service = INoticeServiceImpl.getInstance();
		service.insertNoticeInfo(noticeInfo, wrapper.getFileItemValues("files"));
		
		
		
		
		return "/user/notice/noticeList.do";
	}

}
