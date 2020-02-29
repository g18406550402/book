package com.briup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Article;

public interface ArticleDao extends JpaRepository<Article, Integer>{
	@Query(value="select c.category_id from cms_article c where c.id=?1",nativeQuery=true)
	public Integer findCategoryIdById(Integer id);
	@Query(value="select * from cms_article c where c.category_id=?1",nativeQuery=true)
	public List<Article> findByCategory(Integer categoryId);
	/*@Transactional
	@Modifying
	@Query(value="delete from cms_article where category_id= ?1",nativeQuery=true)
	public void deleteById(Integer id);*/
}
