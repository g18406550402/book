package com.briup.service;


import java.util.List;

import com.briup.bean.Chapter;


public interface IChapterService {
	public void saveOrUpdate(Chapter chapter)throws Exception;
	
	public void deleteById(Integer id)throws Exception;
	
	public Chapter findById(Integer id)throws Exception;
	
	public List<Chapter> findAllChapterById(Integer article_id);
}
