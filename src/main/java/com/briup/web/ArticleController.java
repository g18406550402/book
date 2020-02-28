package com.briup.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.service.IArticleService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
@Api(description="文章相关接口")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation("save or update a article by id")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="ID",paramType="query",dataType="int"),
		@ApiImplicitParam(name="title",value="title",paramType="query",dataType="String"),
		@ApiImplicitParam(name="author",value="author",paramType="query",dataType="String"),
		@ApiImplicitParam(name="categoryId",value="categoryId",paramType="query",dataType="int")
	})
	public Message<String> saveOrUpdate(Integer id,String title,String author,Integer categoryid){
		try {
			Article article = new Article();
			article.setId(id);
			article.setTitle(title);
			article.setAuthor(author);
			article.setPublishDate(new Date());
			article.setClickTimes(0);
			Category category = new Category();
			category.setId(categoryid);
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
	public Message<Article> findById(int id){
		Message<Article> message = null;
		try {
			Article article = articleService.findById(id);
			MessageUtil.success(article);
		} catch (Exception e) {
			MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findAll")
	public Message<List<Article>> findAll(){
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
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
}
