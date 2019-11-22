package kr.or.ddit.admin.mypage.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.mypage.dao.IAdminMypageDao;
import kr.or.ddit.admin.mypage.dao.IAdminMypageDaoImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WithdrawVO;

public class IAdminMypageServiceImpl implements IAdminMypageService {

	private IAdminMypageDao dao;
	private IAdminMypageServiceImpl() {
		dao = IAdminMypageDaoImpl.getInstance();
	}
	
	private static IAdminMypageService service;
	public static IAdminMypageService getInstance() {
		return (service == null) ? new IAdminMypageServiceImpl() : service;
	}
	
	@Override
	public List<MemberVO> memberList(Map<String, String> params) {
		List<MemberVO> list = null;
		try {
			list = dao.memberList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<WithdrawVO> memberListDel(Map<String, String> params) {
		List<WithdrawVO> list = null;
		try {
			list = dao.memberListDel(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void memberDelete(MemberVO membervo) {
		try {
			dao.memberDelete(membervo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String countStar(String star) {
		String cnt = null;
		try {
			cnt = dao.countStar(star);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String totalCountMember(Map<String, String> params) {
		String cnt = null;
		try {
			cnt = dao.totalCountMember(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String totalCountMemberDel(Map<String, String> params) {
		String cnt = null;
		try {
			cnt = dao.totalCountMemberDel(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String countInsertDate(String selectdate) {
		String list = null;
		try {
			list = dao.countInsertDate(selectdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
