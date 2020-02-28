package com.briup.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> findAll() {
		List<Category> list=categoryDao.findAll();
		return list;
	}
	@Override
	public void deleteById(int id) throws Exception {
		Optional<Category> opt = categoryDao.findById(id);
		Category category = opt.isPresent()?opt.get():null;
		if(category!=null) {
			categoryDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}
	@Override
	public void saveOrUpdate(Category category) throws Exception {
		if(category!=null){
			Integer id=category.getId();
			if(id==null) {
				categoryDao.save(category);
			}else {
				Category category_db = categoryDao.findById(id).get();
				String name = category.getName();
				Long code = category.getCode();
				if(name!=null) {
					category_db.setName(name);
				}
				if(code!=0) {
					category_db.setCode(code);
				}
				categoryDao.save(category_db);
			}
		}else {
			throw new Exception("parameter is null");
		}
	}
	@Override
	public Category findById(int id) throws Exception {
		Optional<Category> opt = categoryDao.findById(id);
		Category category = opt.isPresent()?opt.get():null;
		
		if(category!=null){
			System.out.println(category.getArticles());
			return category;
		}else {
			throw new Exception("id is null");
		}
	}
	

}