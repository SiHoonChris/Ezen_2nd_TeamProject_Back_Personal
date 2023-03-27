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
	private static final String Namespace = "ezen.project.IGSJ.product";  

	// 카테고리 넘버에 따른 상품 추출
	@Override
	public List<ProductDTO> getProductList(int num) throws Exception {
		return sqlSession.selectList(Namespace+".getProductList", num);
	} // getProductList()

	
} // public class ProductDAOImpl()
