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
	
	
	
} // public class MemberDAOImpl
