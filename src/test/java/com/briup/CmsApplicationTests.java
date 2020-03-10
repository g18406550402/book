package com.briup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.briup.bean.Article;
import com.briup.bean.ArticleAndCategoryName;
import com.briup.bean.Reader;
import com.briup.dao.ArticleDao;
import com.briup.dao.ChapterDao;
import com.briup.dao.CommentDao;
import com.briup.dao.ReaderDao;
import com.briup.service.IArticleService;
import com.briup.service.ICategoryService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

@SpringBootTest
class CmsApplicationTests {
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ReaderDao readerDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ChapterDao chapterDao;
	@Test
	void test1() throws Exception {
		System.out.println("----------------------------");
		Integer article_id = 13;
		Article article = new Article();
		if(article_id!=null) {
			try {
				article = articleService.findById(article_id);
				System.out.println("未修改前："+article);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ;
			}
			//封装文章信息--更新
			article.setTitle(null);
			article.setAuthor(null);
			article.setIntro(null);
			article.setWords(null);
			article.setState(null);
			article.setImage(null);
			article.setUpdateDate(new Date());
			
			
			
		System.out.println("----------------------------");
		}
	
	}
}