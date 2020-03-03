package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Chapter;
public interface IArticleService {
	public void saveOrUpdate(Article article)throws Exception;
	public Article findById(int id)throws Exception;
	public List<Article> findAll();
	public void deleteById(Integer id)throws Exception;
	public Integer findCategoryIdById(Integer id);
	public List<Chapter> findAllChapterById(Integer article_id);
}
