package com.briup.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.dao.ArticleDao;
import com.briup.service.IArticleService;
@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Article findById(int id) throws Exception {
		Optional<Article> opt = articleDao.findById(id);
		Article article = opt.isPresent()?opt.get():null;
		if(article!=null) {
			article.setClickTimes(article.getClickTimes()+1);
			articleDao.save(article);
			return article;
		}else {
			throw new Exception("id is not present");
		}
		
	}
	@Override
	public void saveOrUpdate(Article article) throws Exception {
		if(article!=null) {
			Integer id = article.getId();
			if(id==null) {
				articleDao.save(article);
			}else {
				//根据id查出文章
				Article article_db = articleDao.findById(id).get();
				//更改标题作者栏目
				String author = article.getAuthor();
				String title = article.getTitle();
				Category category = article.getCategory();
				String content = article.getContent();
				if(author!=null) 
					article_db.setAuthor(author);
				if(title!=null)
					article_db.setTitle(title);
				if(category!=null)
					article_db.setCategory(category);
				if(content!=null)
					article_db.setContent(content);
				articleDao.save(article_db);
			}
		}else{
			throw new Exception("参数为空");
		}
		
		
	}
	@Override
	public List<Article> findAll() {
		List<Article> list = articleDao.findAll();
		return list;
	}
	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Article> opt = articleDao.findById(id);
		Article article = opt.isPresent()?opt.get():null;
		if(article!=null) {
			System.out.println(article);
			System.out.println(article.getCategory());
			System.out.println("------------"+id+"-----------");
			article.setCategory(null);
			articleDao.save(article);
			articleDao.deleteById(id);
		}else {
			throw new Exception("id is not present in database");
		}
	}
	@Override
	public Integer findCategoryIdById(Integer id) {
		articleDao.findCategoryIdById(id);
		return id;
	}
	
}
