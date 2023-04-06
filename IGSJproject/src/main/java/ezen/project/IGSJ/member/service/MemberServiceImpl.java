package ezen.project.IGSJ.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ezen.project.IGSJ.member.dao.MemberDAO;
import ezen.project.IGSJ.member.domain.MemberDTO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	//로그인 기능
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberLogin(memberDTO);
	} // memberLogin()
	
	// 카카오API 활용 로그인
	@Override
	public MemberDTO KakaoLogin(MemberDTO memberDTO) throws Exception {
        // 1. 가입되어 있는지 확인(MemberDTO에 저장되어 있는 회원인지 확인)
		MemberDTO memberCheck = memberDAO.KakaoSignedMemberCheck(memberDTO);
		MemberDTO aboutMember = null;
		// 2. 가입이 되어 있으면 로그인(MemberDTO에 회원 정보 저장)	
		if(memberCheck != null)             {aboutMember = memberCheck;}
		// 3. 가입이 안되어 있으면 회원가입(MemberDTO에 회원 정보 저장)하고, 이어서 바로 로그인 실행			
		else                                {aboutMember = memberDAO.KakaoSignUp(memberDTO);}
		// 4. 사용자 정보 반환
		return aboutMember;
	} // KakaoLogin()
	
	
} // public class MemberServiceImpl
