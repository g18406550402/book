package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
@Api(description="栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("/findAll")
	@ApiOperation("select all")
	public Message<List<Category>> findAll(){
		List<Category> categoryList = categoryService.findAll();
		return MessageUtil.success(categoryList);
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("")
	@ApiImplicitParam(name="id",value="栏目id",paramType="query",dataType="int",required=true)
	public Message<String> deleteById(int id){
		Message<String> message = null;
		try {
			categoryService.deleteById(id);
			message = MessageUtil.success("delete success");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@PutMapping("/saveOrUpdate")
	@ApiOperation("保存或更")
	
	public Message<String> saveOrUpdate(@RequestParam(required = false)Integer id,String name,int code){
		System.out.println("id:----------"+id);
		Category category = new Category(id, code, name);
		Message<String> message = null;
		try {
			categoryService.saveOrUpdate(category);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	@GetMapping("/findById")
	@ApiOperation("delete lanmu by id")
	@ApiImplicitParam(name="id",paramType="query",dataType="int",required=true)
	public Message<Category> findById(int id){
		Message<Category> message = null;
		try {
			Category category = categoryService.findById(id);
			message = MessageUtil.success(category);
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
}
