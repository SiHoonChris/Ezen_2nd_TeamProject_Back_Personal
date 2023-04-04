package ezen.project.IGSJ.product.service;

import java.util.List;

import ezen.project.IGSJ.product.domain.ProductDTO;


public interface ProductService {
	
	// 카테고리 넘버에 따른 상품 추출
	public List<ProductDTO> getProductList(int num) throws Exception;
	
	// 검색어에 따른 상품 추출
	public List<ProductDTO> getProducts(String type) throws Exception;
	
	// 선택된 상품에 대한 정보
	public ProductDTO getProductInfo(String pno) throws Exception;
	
	// 모든 상품 => 주문량 상위 10종목으로 수정하기
	public List<ProductDTO> allProductInfo() throws Exception;
	
	// 신상품 10개 추출
	public List<ProductDTO> newProductInfo() throws Exception;
	
} // public interface ProductService
