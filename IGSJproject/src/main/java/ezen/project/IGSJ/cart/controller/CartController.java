package ezen.project.IGSJ.cart.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.cart.domain.CartDTO;
import ezen.project.IGSJ.cart.service.CartService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	//장바구니 등록
	@ResponseBody
	@PostMapping("/cartWrite")
	public boolean cartWrite(@RequestBody CartDTO cartDTO) throws Exception{
		// 0) ProductDetail.vue에서 '장바구니' 버튼 실행 내용 받기(받아서 List<CartDTO>로 가공)
		JSONParser parser       = new JSONParser();
		JSONObject sizeAndCount = (JSONObject) parser.parse(cartDTO.getSize());
		String     userId       = cartDTO.getUserId();
		String     pno          = cartDTO.getPno();
		
		Set<String> sizes = sizeAndCount.keySet();
		String[] sizeArr = new String[sizes.size()];
		int n = 0;
		for (String size : sizes) {sizeArr[n++] = size;}
		
		List<CartDTO> prdToCart = new ArrayList<>(sizeArr.length);
		for(int i=0; i<sizeArr.length; i++) {
			String rs = RandomStringUtils.randomNumeric(6);
			String cartNum = userId + "_" + rs;
			String size = sizeArr[i];
			int productCnt = Integer.parseInt(sizeAndCount.get(size).toString());			
			if(productCnt != 0) {prdToCart.add(new CartDTO(cartNum, userId, pno, productCnt, size));}
		}
		
		// CartDAOImpl.java 에서...
		// 1) cartSelect(장바구니 내 중복 내용 확인) 실행
		// 2) 있으면 cartUpdate(장바구니 내 상품 수량 증가) 실행
		// 3) 없으면 cartWrite(장바구니 내 새 상품 등록) 실행
		return cartService.cartWrite(prdToCart)==0 ? false : true;
	} // cartWrite()
	
	
	// 장바구니 목록
	@ResponseBody
	@GetMapping("/cartList/{userId}")
	public List<CartDTO> cartList(@PathVariable String userId) throws Exception {
		List<CartDTO> cartList = cartService.cartList(userId);
		return cartList;
	} // cartList()
	
	// 장바구니 삭제
	@ResponseBody
	@PostMapping("/cartDelete")
	public boolean cartDelete(@RequestBody CartDTO cartDTO) throws Exception {	
		int cartDelete = cartService.cartDelete(cartDTO);
		if(cartDelete == 1) {return true;}
		else {return false;}
	} // cartDelete()

	
} // public class CartController

