package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;


public interface ICategoryService {
	
	public List<Category> findAll();
	
	public void deleteById(int id)throws Exception;
	
	public void saveOrUpdate(Category category)throws Exception;
	
	public Category findById(int id)throws Exception;
	
	public Integer findIdByName(String name)throws Exception;
	
	public List<Article> findByCategory(Integer categoryId);
	
	public String findNameById(Integer id);
	
}
