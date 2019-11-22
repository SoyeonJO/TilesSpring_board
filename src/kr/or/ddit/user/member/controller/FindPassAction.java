package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class FindPassAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		String name = request.getParameter("name");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", id);
		params.put("mem_tel", tel);
		params.put("mem_name", name);
		
		MemberVO memberInfo = new MemberVO();
		
		IMemberService service = IMemberServiceImpl.getInstance();
		memberInfo = service.memberPassSearch(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData;
		
		try {
			jsonData = mapper.writeValueAsString(memberInfo);
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
