package com.briup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Chapter;
import com.briup.service.IChapterService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/chapter")
@Api(description="章节相关接口")
public class ChapterController {
	@Autowired
	private IChapterService chapterService;
	
	@PostMapping("/saveOrUpdate")
	@ApiOperation("更新或插入章节")
	public Message<String> saveOrUpdate(Chapter chapter){
		try {
			chapterService.saveOrUpdate(chapter);
			return MessageUtil.success("更新成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(500, e.getMessage());
		}
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查找章节")
	public Message<Chapter> findById(Integer id){
		try {
			Chapter chapter = chapterService.findById(id);
			return MessageUtil.success(chapter);
		} catch (Exception e) {
			return MessageUtil.error(500, e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除章节")
	public Message<String> deleteById(Integer id){
		try {
			chapterService.deleteById(id);
			return MessageUtil.success("删除成功！");
		} catch (Exception e) {
			return MessageUtil.error(500, e.getMessage());
		}
	}
}
