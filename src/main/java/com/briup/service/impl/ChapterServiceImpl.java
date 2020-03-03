package com.briup.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.Chapter;
import com.briup.dao.ChapterDao;
import com.briup.service.IChapterService;
@Service
public class ChapterServiceImpl implements IChapterService {
	@Autowired
	private ChapterDao chapterDao;
	
	@Override
	public void saveOrUpdate(Chapter chapter) throws Exception {
		if(chapter!=null) {
			Integer id = chapter.getId();
			if(id==null) {
				chapterDao.save(chapter);
			}else {
				//根据id查出文章
				Chapter chapter_db = chapterDao.findById(id).get();
				//更改标题作者栏目
				String subtitle = chapter.getSubtitle();
				String content = chapter.getContent();
				if(subtitle!=null) 
					chapter_db.setSubtitle(subtitle);
				if(content!=null)
					chapter_db.setContent(content);
				chapterDao.save(chapter_db);
			}
		}else{
			throw new Exception("参数ID为空");
		}
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Chapter> opt = chapterDao.findById(id);
		Chapter chapter = opt.isPresent()?opt.get():null;
		if(chapter!=null) {
			chapterDao.deleteById(id);
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}

	@Override
	public Chapter findById(Integer id) throws Exception {
		Optional<Chapter> opt = chapterDao.findById(id);
		Chapter chapter = opt.isPresent()?opt.get():null;
		if(chapter!=null) {
			return chapter;
		}else {
			throw new Exception("该id在数据库中不存在！");
		}
	}

}
