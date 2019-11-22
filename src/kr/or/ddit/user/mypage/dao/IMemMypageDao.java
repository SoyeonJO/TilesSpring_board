package kr.or.ddit.user.mypage.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AllBoardVO;
import kr.or.ddit.vo.MemberVO;

public interface IMemMypageDao {

	public List<AllBoardVO> myboardList(Map<String, String> params) throws SQLException;
	
	public List<AllBoardVO> myFreeBList(Map<String, String> params) throws SQLException;
	
	public List<AllBoardVO> myQnaBList(Map<String, String> params) throws SQLException;
	
	public String totalCountFree(Map<String, String> params) throws SQLException;

	public String totalCountQna(Map<String, String> params) throws SQLException;
}
