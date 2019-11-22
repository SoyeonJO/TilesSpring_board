package kr.or.ddit.user.mypage.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AllBoardVO;

public interface IMemMypageService {

	public List<AllBoardVO> myboardList(Map<String, String> params);
	
	public List<AllBoardVO> myFreeBList(Map<String, String> params);
	
	public List<AllBoardVO> myQnaBList(Map<String, String> params);
	
	public String totalCountFree(Map<String, String> params);

	public String totalCountQna(Map<String, String> params);

}
