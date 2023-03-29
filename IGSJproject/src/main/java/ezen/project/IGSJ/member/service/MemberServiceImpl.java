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
	
	
} // public class MemberServiceImpl
