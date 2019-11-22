package kr.or.ddit.filter;

import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAKey;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.utiles.CryptoGenerator;

import org.apache.commons.lang3.StringUtils;

public class CryptoGeneratorFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		String url = request.getRequestURI().toString();
		if(request.getRequestURL().toString().split("/")[request.getRequestURL().toString().split("/").length-1].equals("loginCheck.do")) {
			filterChain.doFilter(servletRequest, servletResponse);
		}else {
			HttpSession session = request.getSession();
			
			Map<String, String> publicKeyMap = CryptoGenerator.generatePairKey(session);
			
			request.setAttribute("publicKeyMap", publicKeyMap);
			
			filterChain.doFilter(servletRequest, servletResponse);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
