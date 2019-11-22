package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.notice.service.INoticeService;
import kr.or.ddit.admin.notice.service.INoticeServiceImpl;


public class NoticeDeleteAction implements IAction {
	private boolean Flag = true;

	@Override
	public boolean isRedirect() {
		return Flag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String notice_no = request.getParameter("notice_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("notice_no", notice_no);
		
		INoticeService service = INoticeServiceImpl.getInstance();
		service.deleteNoticeInfo(params);
		
	     return "/admin/notice/noticeList.do";

		
	}

}
