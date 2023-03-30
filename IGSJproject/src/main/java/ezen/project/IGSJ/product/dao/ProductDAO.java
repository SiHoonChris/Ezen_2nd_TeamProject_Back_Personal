package ezen.project.IGSJ.product.dao;

import java.util.List;

import ezen.project.IGSJ.product.domain.ProductDTO;


public interface ProductDAO {
	
	// 카테고리 넘버에 따른 상품 추출
	public List<ProductDTO> getProductList(int num) throws Exception;
	
	// 검색어에 따른 상품 추출
	public List<ProductDTO> getProducts(String type) throws Exception;
	
	// 선택된 상품에 대한 정보
	public ProductDTO getProductInfo(String pno) throws Exception;	
	
} // public interface ProductDao
