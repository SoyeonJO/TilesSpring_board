package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.ZipVO;

public class ZipcodeSearchFormAction implements IAction {

	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String dong = request.getParameter("dong");

		IMemberService service = IMemberServiceImpl.getInstance();
		List<ZipVO> zipcodeList = service.zipcodeList(dong);

		ObjectMapper mapper = new ObjectMapper();
		String jsonData;
		try {
			jsonData = mapper.writeValueAsString(zipcodeList);
			System.out.println(jsonData);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
