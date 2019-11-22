package kr.or.ddit.user.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WithdrawVO;
import kr.or.ddit.vo.ZipVO;

public interface IMemberService {
	
	// 회원 가입 - insert
	public void memberInsert(MemberVO membervo);
	
	// 아이디 찾기
	public MemberVO memberIdSearch(Map<String, String> params); 
	
	// 비밀 번호 찾기
	public MemberVO memberPassSearch(Map<String, String> params);
	
	// 회원 리스트
	public List<MemberVO> memberList(Map<String, String> params);
	
	// 회원 정보 & 로그인
	public MemberVO memberInfo(Map<String, String> params);
	
	// 회원 정보 수정
	public void memberUpdate(MemberVO membervo);
	
	// 회원 탈퇴
	public void memberDelete(String mem_id);
	public void memDelinsert(WithdrawVO member);
	
	// 우편번호 찾기
	public List<ZipVO> zipcodeList(String dong);
	
}
