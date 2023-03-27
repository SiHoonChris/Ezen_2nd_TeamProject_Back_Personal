package ezen.project.IGSJ.category.dao;


import java.util.List;

import ezen.project.IGSJ.category.domain.CategoryDTO;

public interface CategoryDAO {

	// 카테고리 정보 가져오기(대분류, 중분류, 카테고리명)
	public List<CategoryDTO> getCategoryInfos(int num) throws Exception;



} // public interface CategoryDAO()