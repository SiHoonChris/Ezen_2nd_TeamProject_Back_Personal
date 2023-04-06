package ezen.project.IGSJ.member.dao;


import ezen.project.IGSJ.member.domain.MemberDTO;

public interface MemberDAO {

	//로그인 기능
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	
	// 카카오API 활용 로그인 : 1. 가입되어 있는지 확인(MemberDTO에 저장되어 있는 회원인지 확인)
	public MemberDTO KakaoSignedMemberCheck(MemberDTO memberDTO) throws Exception;
	
	// 카카오API 활용 로그인 : 3. 가입이 안되어 있으면 회원가입(MemberDTO에 회원 정보 저장)하고, 이어서 바로 로그인 실행	
	public MemberDTO KakaoSignUp(MemberDTO memberDTO) throws Exception;
	
} // public interface MemberDAO
