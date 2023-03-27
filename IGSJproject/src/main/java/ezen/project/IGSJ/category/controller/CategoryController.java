package ezen.project.IGSJ.category.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.category.domain.CategoryDTO;
import ezen.project.IGSJ.category.service.CategoryService;

@Controller("CategoryController")
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired(required = false)
	private CategoryDTO      categoryDTO;
	@Autowired
	private CategoryService  categoryService;


	// 카테고리 정보 가져오기(대분류, 중분류, 카테고리명)
	@GetMapping("/items/{num}")
	@ResponseBody
	public List<CategoryDTO> getCategoryInfos(@PathVariable int num) throws Exception {
		System.out.println(num);
		List<CategoryDTO> categoryInfos = categoryService.getCategoryInfos(num);
		return categoryInfos;
	} // getCategoryInfos


} // public class CategoryController() 