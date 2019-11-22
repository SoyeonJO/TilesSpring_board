package kr.or.ddit.admin.hospital.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class GetSidoAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String result = "";
		try {
			BufferedReader br = null;
			
			String addr = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?ServiceKey=";
			String serviceKey = "c72thrZqj4pSWdTdpGB2BENQT8L7CpkinD4jhP81yyjo7cya%2Bgau50HkikMVoBi5XG0WC4ZnHv3lJGYyH212bg%3D%3D";
			String parameter = "&numOfRows=10";
			
			
			addr = addr + serviceKey + parameter;
			
			URL url = new URL(addr);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			
			String line;
			
			while((line = br.readLine()) != null){
				result = result + line + "\n";
			}
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println(result);
			
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
