package ezen.project.IGSJ.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.member.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.memberMapper";
	
	
	//로그인 기능
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {	
		return sqlSession.selectOne(NAME_SPACE + ".memberLogin", memberDTO);
	} // memberLogin()

	// 카카오API 활용 로그인 : 1. 가입되어 있는지 확인(MemberDTO에 저장되어 있는 회원인지 확인)
	@Override
	public MemberDTO KakaoSignedMemberCheck(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAME_SPACE+".KakaoSignedMemberCheck", memberDTO);
	} // KakaoSignedMemberCheck()

	// 카카오API 활용 로그인 : 3. 가입이 안되어 있으면 회원가입(MemberDTO에 회원 정보 저장)하고, 이어서 바로 로그인 실행
	@Override
	public MemberDTO KakaoSignUp(MemberDTO memberDTO) throws Exception {
		sqlSession.selectOne(NAME_SPACE+".KakaoSignUp", memberDTO);
		return sqlSession.selectOne(NAME_SPACE+".KakaoSignedMemberCheck", memberDTO);
	} // KakaoSignUp
	
	
	
} // public class MemberDAOImpl
