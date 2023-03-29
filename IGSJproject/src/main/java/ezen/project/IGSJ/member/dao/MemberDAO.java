package ezen.project.IGSJ.member.dao;


import ezen.project.IGSJ.member.domain.MemberDTO;

public interface MemberDAO {

	//로그인 기능
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;
	
		
} // public interface MemberDAO
