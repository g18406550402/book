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
import io.swagger.annotations.ApiImplicitParam;
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
	@ApiOperation(value="保存或更新一篇文章")
	public Message<String> saveOrUpdate(ArticleAndCategoryName articleAndCategoryName){
		String categoryName = articleAndCategoryName.getCategoryNmae();
		Integer categoryId=null;
		try {
			//根据输入的栏目名查找栏目id
			categoryId = categoryService.findIdByName(categoryName);
		} catch (Exception e1) {
			return MessageUtil.error(500, e1.getMessage());
		}
		try {
			Article article = new Article();
			article.setId(articleAndCategoryName.getId());
			article.setTitle(articleAndCategoryName.getTitle());
			article.setAuthor(articleAndCategoryName.getAuthor());
			article.setIntro(articleAndCategoryName.getIntro());
			article.setUpdateDate(new Date());
			article.setClickTimes(0);
			article.setWords(articleAndCategoryName.getWords());
			article.setState(articleAndCategoryName.getState());
			if(categoryId!=null)
				article.setCategory_id(categoryId);
			else {
				article.setCategory_id(articleService.findCategoryIdById(articleAndCategoryName.getId()));
			}
			articleService.saveOrUpdate(article);
			return MessageUtil.success("更新成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	@GetMapping("/findById")
	@ApiOperation("根据id查询文章")
	@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int",required=true)
	public Message<ArticleAndCategoryName> findById(int id){
		Message<ArticleAndCategoryName> message = null;
		try {
			Article article = articleService.findById(id);
			String name = categoryService.findNameById(article.getCategory_id());
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate(), 
					article.getTitle(),article.getState(),article.getWords(), name);
			message=MessageUtil.success(ac);
		} catch (Exception e) {
			message=MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@ApiOperation("查询所有文章")
	@GetMapping("/findAll")
	public Message<List<ArticleAndCategoryName>> findAll(){
		List<Article> list = articleService.findAll();
		List<ArticleAndCategoryName> aclist=new ArrayList<ArticleAndCategoryName>();
		for(Article article:list) {
			String categoryName=categoryService.findNameById(article.getId());
			ArticleAndCategoryName ac = new ArticleAndCategoryName(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getIntro(), article.getUpdateDate(), 
					article.getTitle(),article.getState(),article.getWords(), categoryName);
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除文章")
	@ApiImplicitParam(name="id",value="文章id",paramType="query",dataType="int",required=true)
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
	
	@ApiOperation("根据标题或作者查询文章")
	@GetMapping("/findByTitleOrAuthor")
	@ApiImplicitParam(name="titleOrAuthor",value="文章的标题或作者",paramType="query",dataType="String",required=true)
	public Message<List<Article>> findByTitleOrArthor(String titleOrAuthor){
		
		List<Article> articleList;
		try {
			articleList = articleService.findByTitleOrArthor(titleOrAuthor);
			return MessageUtil.success(articleList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
		
	}
}
