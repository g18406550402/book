package com.briup;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.briup.bean.Article;
import com.briup.dao.ArticleDao;

@SpringBootTest
class CmsApplicationTests {
	@Autowired
	private ArticleDao articleDao;
	@Test
	void contextLoads() {
		Article article = articleDao.findById(8).get();
		article.setCategory(null);
		articleDao.save(article);
		articleDao.deleteById(8);
	}

}
