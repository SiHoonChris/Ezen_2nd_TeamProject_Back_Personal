package ezen.project.IGSJ.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.project.IGSJ.category.dao.CategoryDAO;
import ezen.project.IGSJ.category.domain.CategoryDTO;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	public CategoryDAO categoryDAO;

	// 카테고리 정보 가져오기(대분류, 중분류, 카테고리명)
	@Override
	public List<CategoryDTO> getCategoryInfos(int num) throws Exception {
		return categoryDAO.getCategoryInfos(num);
	} // getCategoryInfos()


} // public class CategoryServiceImpl()