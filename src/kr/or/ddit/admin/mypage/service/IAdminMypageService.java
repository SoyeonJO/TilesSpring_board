package kr.or.ddit.admin.mypage.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WithdrawVO;

public interface IAdminMypageService {

	// 회원 조회 및 검색
	public List<MemberVO> memberList(Map<String, String> params);
	
	public String countInsertDate(String selectdate);
	
	// 탈퇴 회원 조회 및 검색
	public List<WithdrawVO> memberListDel(Map<String, String> params);
	
	// 페이지네이션
	public String totalCountMember(Map<String, String> params);
	
	// 탈퇴회원 페이지네이션
	public String totalCountMemberDel(Map<String, String> params);
	
	// 회원 강제 탈퇴
	public void memberDelete(MemberVO membervo);
	
	// 탈퇴 회원 별점 통계용
	public String countStar(String star);
	
	
	
}
