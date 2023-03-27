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

	
} // public class ProductServiceImpl()
