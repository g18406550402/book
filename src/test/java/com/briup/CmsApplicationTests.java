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
		Article article = articleService.findById(50);
		System.out.println(article);
		System.out.println("----------------------------");
	}
	
}
