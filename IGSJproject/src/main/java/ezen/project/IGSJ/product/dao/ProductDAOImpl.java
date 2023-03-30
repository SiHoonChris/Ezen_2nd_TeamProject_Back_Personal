package ezen.project.IGSJ.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.product.domain.ProductDTO;


@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "mappers.productMapper";

	
	// 카테고리 넘버에 따른 상품 추출
	@Override
	public List<ProductDTO> getProductList(int num) throws Exception {
		return sqlSession.selectList(Namespace+".getProductList", num);
	} // getProductList()

	// 검색어에 따른 상품 추출
	@Override
	public List<ProductDTO> getProducts(String type) throws Exception {
		return sqlSession.selectList(Namespace+".getProducts", type);
	} // getProducts()

	// 선택된 상품에 대한 정보
	@Override
	public ProductDTO getProductInfo(String pno) throws Exception {
		return sqlSession.selectOne(Namespace+".getProductInfo", pno);
	} // getProductInfo()

	
} // public class ProductDAOImpl()
