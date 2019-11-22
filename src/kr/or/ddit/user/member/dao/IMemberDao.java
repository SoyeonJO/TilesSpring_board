package kr.or.ddit.user.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WithdrawVO;
import kr.or.ddit.vo.ZipVO;

public interface IMemberDao {

	// 회원 가입 - insert
	public void memberInsert(MemberVO membervo) throws SQLException;
	
	// 아이디 찾기
	public MemberVO memberIdSearch(Map<String, String> params) throws SQLException; 
	
	// 비밀 번호 찾기
	public MemberVO memberPassSearch(Map<String, String> params) throws SQLException;
	
	// 회원 리스트
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException;
	
	// 회원 정보 & 로그인
	public MemberVO memberInfo(Map<String, String> params) throws SQLException;
	
	// 회원 정보 수정
	public void memberUpdate(MemberVO membervo) throws SQLException;
	
	// 회원 탈퇴
	public void memberDelete(String mem_id) throws SQLException;
	public void memDelinsert(WithdrawVO member) throws SQLException;
	
	// 우편번호 찾기
	public List<ZipVO> zipcodeList(String dong) throws SQLException;
}
