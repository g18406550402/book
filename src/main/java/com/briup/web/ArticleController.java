package com.briup.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.ArticleAndCategoryName;
import com.briup.bean.Category;
import com.briup.bean.Chapter;
import com.briup.service.IArticleService;
import com.briup.service.ICategoryService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
@Api(description="文章相关接口")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation(value="save or update a article by id",notes="category.code,category.name可以不用谢")
	/*@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="ID",paramType="query",dataType="int"),
		@ApiImplicitParam(name="title",value="title",paramType="query",dataType="String"),
		@ApiImplicitParam(name="author",value="author",paramType="query",dataType="String"),
		@ApiImplicitParam(name="categoryId",value="categoryId",paramType="query",dataType="int")
	})*/
	public Message<String> saveOrUpdate(ArticleAndCategoryName articleAndCategoryName){
		String categoryName = articleAndCategoryName.getCategoryNmae();
		Integer categoryId=null;
		try {
			categoryId = categoryService.findIdByName(categoryName);
		} catch (Exception e1) {
			return MessageUtil.error(500, e1.getMessage());
		}
		try {
			Article article = new Article();
			article.setId(articleAndCategoryName.getId());
			article.setTitle(articleAndCategoryName.getTitle());
			article.setAuthor(articleAndCategoryName.getAuthor());
			article.setContent(articleAndCategoryName.getContent());
			article.setPublishDate(new Date());
			article.setClickTimes(0);
			Category category = new Category();
			if(categoryId!=null)
				category.setId(categoryId);
			else {
				category.setId(articleService.findCategoryIdById(articleAndCategoryName.getId()));
			}
			article.setCategory(category);
			articleService.saveOrUpdate(article);
			return MessageUtil.success("save success!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@GetMapping("/findById")
	@ApiOperation("find a article by id")
	public Message<ArticleAndCategoryName> findById(int id){
		Message<ArticleAndCategoryName> message = null;
		try {
			Article article = articleService.findById(id);
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getContent(), article.getPublishDate(), 
					article.getTitle(), article.getCategory().getName());
			message=MessageUtil.success(ac);
		} catch (Exception e) {
			message=MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findAll")
	public Message<List<ArticleAndCategoryName>> findAll(){
		List<Article> list = articleService.findAll();
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getContent(), article.getPublishDate(), 
					article.getTitle(), article.getCategory().getName());
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除文章")
	public Message<String> deleteById(Integer id){
		Message<String> message = null;
		try {
			articleService.deleteById(id);
			message = MessageUtil.success("delete success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findAllChapter")
	public Message<List<Chapter>> findAllChapter(Integer article_id){
		List<Chapter> chapterList = articleService.findAllChapterById(article_id);
		return MessageUtil.success(chapterList);
	}
}
