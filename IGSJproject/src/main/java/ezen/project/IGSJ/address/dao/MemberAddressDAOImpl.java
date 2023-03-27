package ezen.project.IGSJ.address.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;

@Repository
public class MemberAddressDAOImpl implements MemberAddressDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberAddressDAOImpl.class);
	
	private static final String NAME_SPACE = "mappers.memberAddressMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void signUpAddressMember(MemberAddressDTO memberAddressDTO) throws Exception {
		
		logger.info("회원 주소 추가 signUpMember - DAO");
		
		sqlSession.insert(NAME_SPACE + ".signUpAddressMember", memberAddressDTO);
		
	}
}
