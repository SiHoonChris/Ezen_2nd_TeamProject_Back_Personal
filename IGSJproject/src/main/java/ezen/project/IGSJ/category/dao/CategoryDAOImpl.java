package ezen.project.IGSJ.category.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ezen.project.IGSJ.category.domain.CategoryDTO;


@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "ezen.project.IGSJ.category";  

	// 카테고리 정보 가져오기(대분류, 중분류, 카테고리명)
	@Override
	public List<CategoryDTO> getCategoryInfos(int num) throws Exception {		
		return sqlSession.selectList(Namespace + ".getCategoryInfos", num);
	} // getCategoryInfos()


} // public class CategoryDAOImpl()