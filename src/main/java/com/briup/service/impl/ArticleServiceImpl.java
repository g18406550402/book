package com.briup.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.bean.Article;
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
			if(article.getClickTimes()!=null)
				article.setClickTimes(article.getClickTimes()+1);
			articleDao.save(article);
			return article;
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
		
	}
	@Override
	public void saveOrUpdate(Article article) throws Exception {
		if(article!=null) {
			Integer id = article.getId();
			if(id==null) {
				article.setClickTimes(0);
				articleDao.save(article);
			}else {
				//根据id查出文章
				Article article_db = articleDao.findById(id).get();
				//更改标题作者栏目字数状态
				String author = article.getAuthor();
				String title = article.getTitle();
				Integer category_id = article.getCategory_id();
				String intro = article.getIntro();
				Integer words = article.getWords();
				String state = article.getState();
				String image = article.getImage();
				if((author!=null)&&(author!="")) 
					article_db.setAuthor(author);
				if(title!=null&&(title!=""))
					article_db.setTitle(title);
				if(category_id!=null)
					article_db.setCategory_id(category_id);
				if(intro!=null&&(intro!=""))
					article_db.setIntro(intro);
				if(words!=null)
					article_db.setWords(words);
				if(state!=null&&(state!=""))
					article_db.setState(state);
				if(image!=null&&(image!=""))
					article_db.setImage(image);
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
			//article.setCategory(null);
			//articleDao.save(article);
			articleDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}
	@Override
	public Integer findCategoryIdById(Integer id) {
		articleDao.findCategoryIdById(id);
		return id;
	}
	
	@Override
	public List<Article> findByTitleOrArthor(String titleOrAuthor)throws Exception {
		List<Article> articleList = articleDao.findByTitleOrArthor(titleOrAuthor);
		if(articleList!=null)
			return articleList;
		else 
			throw new Exception("没有想要的书籍！");
	}
	
}
