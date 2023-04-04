package ezen.project.IGSJ.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.product.dao.ProductDAO;
import ezen.project.IGSJ.product.domain.ProductDTO;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductDAO productDAO;
	
	// 카테고리 넘버에 따른 상품 추출
	@Override
	public List<ProductDTO> getProductList(int num) throws Exception {
		return productDAO.getProductList(num);
	} // getProductList()

	// 검색어에 따른 상품 추출
	@Override
	public List<ProductDTO> getProducts(String type) throws Exception {
		return productDAO.getProducts(type);
	} // getProducts()

	// 선택된 상품에 대한 정보
	@Override
	public ProductDTO getProductInfo(String pno) throws Exception {
		return productDAO.getProductInfo(pno);
	} // getProductInfo()

	// 모든 상품 => 주문량 상위 10종목으로 수정하기
	public List<ProductDTO> allProductInfo() throws Exception{
		return productDAO.allProductInfo();
	} // allProductInfo()
	
	// 신상품 10개 추출
	public List<ProductDTO> newProductInfo() throws Exception{
		return productDAO.newProductInfo();
	} // newProductInfo()
	
} // public class ProductServiceImpl()
