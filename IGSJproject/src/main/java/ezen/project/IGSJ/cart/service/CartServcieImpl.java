package ezen.project.IGSJ.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.cart.dao.CartDAO;
import ezen.project.IGSJ.cart.domain.CartDTO;

@Service
public class CartServcieImpl implements CartService {
	@Autowired
	private CartDAO cartDAO;
	
	//장바구니 등록
	@Override
	public int cartWrite(List<CartDTO> cartDTO) throws Exception {
		return cartDAO.cartWrite(cartDTO);
	} // cartWrite()
	
	//장바구니 목록
	@Override
	public List<CartDTO> cartList(String userId) throws Exception {
		return cartDAO.cartList(userId);
	} // cartList()
	
	//장바구니 삭제
	@Override
	public int cartDelete(CartDTO cartDTO) throws Exception {
		return cartDAO.cartDelete(cartDTO);
	} // cartDelete()
	
} // public class CartServcieImpl
