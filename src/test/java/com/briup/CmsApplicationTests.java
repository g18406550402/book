package com.briup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.briup.bean.Article;
import com.briup.bean.Reader;
import com.briup.dao.ArticleDao;
import com.briup.dao.ChapterDao;
import com.briup.dao.CommentDao;
import com.briup.dao.ReaderDao;

@SpringBootTest
class CmsApplicationTests {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ReaderDao readerDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ChapterDao chapterDao;
	@Test
	void test1() {
		
	}

}
