package kr.or.ddit.admin.qnaboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.qnaboard.service.IQnaBoardService;
import kr.or.ddit.admin.qnaboard.service.IQnaBoardServiceImpl;

public class DeleteQnaAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String qa_no = request.getParameter("qa_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("qa_no", qa_no);
		
		IQnaBoardService service = IQnaBoardServiceImpl.getInstance();
		service.deleteInfo(params);
		
		return "/admin/qna/qnaList.do";
	}

}
