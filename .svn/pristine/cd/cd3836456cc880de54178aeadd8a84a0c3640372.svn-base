package kr.or.ddit.admin.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class NoticeFormAction implements IAction {

	private boolean Flag = false;
	@Override
	public boolean isRedirect() {
		return Flag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		return "/admin/notice/noticeForm.tiles";
	}

}
