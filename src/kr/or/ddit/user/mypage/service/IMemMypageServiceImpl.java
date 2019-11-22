package kr.or.ddit.user.mypage.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.mypage.dao.IMemMypageDao;
import kr.or.ddit.user.mypage.dao.IMemMypageDaoImpl;
import kr.or.ddit.vo.AllBoardVO;
import kr.or.ddit.vo.MemberVO;

public class IMemMypageServiceImpl implements IMemMypageService {

	private IMemMypageDao dao;
	private IMemMypageServiceImpl() {
		dao = IMemMypageDaoImpl.getInstance();
	}
	
	private static IMemMypageService service;
	public static IMemMypageService getInstance() {
		return (service == null) ? new IMemMypageServiceImpl() : service;
	}
	
	@Override
	public List<AllBoardVO> myboardList(Map<String, String> params) {
		List<AllBoardVO> list = null;
		try {
			list = dao.myboardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AllBoardVO> myFreeBList(Map<String, String> params) {
		List<AllBoardVO> list = null;
		try {
			list = dao.myFreeBList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AllBoardVO> myQnaBList(Map<String, String> params) {
		List<AllBoardVO> list = null;
		try {
			list = dao.myQnaBList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String totalCountFree(Map<String, String> params) {
		String cnt = null;
		try {
			cnt = dao.totalCountFree(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String totalCountQna(Map<String, String> params) {
		String cnt = null;
		try {
			cnt = dao.totalCountQna(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
