package ezen.project.IGSJ.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.cart.domain.CartDTO;


@Repository
public class CartDAOImpl implements CartDAO {
	private static final String NAME_SPACE = "mappers.cartMapper";
	@Autowired
	private SqlSession sqlSession;
	
	//장바구니 등록
	@Override
	public int cartWrite(List<CartDTO> cartDTO) throws Exception {
		int numOfAdded = 0;
		for(int i=0; i<cartDTO.size(); i++) {
			numOfAdded += sqlSession.insert(NAME_SPACE + ".cartWrite", cartDTO.get(i));
		}
		return numOfAdded; 
	} // cartWrite()
	
	//장바구니 목록
	@Override
	public List<CartDTO> cartList(String userId) throws Exception {	
		return sqlSession.selectList(NAME_SPACE + ".cartList", userId);
	} // cartList()
	
	//장바구니 삭제
	@Override
	public int cartDelete(CartDTO cartDTO) throws Exception {
		return sqlSession.delete(NAME_SPACE + ".cartDelete", cartDTO);	
	} // cartDelete()
	
	
} // public class CartDAOImpl
