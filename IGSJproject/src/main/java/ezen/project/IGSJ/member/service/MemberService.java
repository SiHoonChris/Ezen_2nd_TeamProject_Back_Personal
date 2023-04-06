package ezen.project.IGSJ.member.service;

import ezen.project.IGSJ.member.domain.MemberDTO;

public interface MemberService {

	//로그인 기능
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	
	// 카카오API 활용 로그인
	public MemberDTO KakaoLogin(MemberDTO memberDTO) throws Exception;
	
	
} // public interface MemberService
