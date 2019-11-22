package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeViewAction implements IAction {

	private boolean Flag = false;

	@Override
	public boolean isRedirect() {
		return Flag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String notice_no = request.getParameter("notice_no");
		
		Map<String, String> notice = new HashMap<String, String>();

		INoticeService service = INoticeServiceImpl.getInstance();
		
		notice.put("notice_no", notice_no); 
		
		NoticeVO noticeInfo = service.noticeInfo(notice);
		
		
		request.setAttribute("noticeInfo", noticeInfo);
		
		return "/user/notice/noticeView.tiles";
	}

}
