package com.briup.service;

import java.util.List;

import com.briup.bean.Comment;
import com.briup.bean.Reader;

public interface IReaderService {
	public List<Reader> findAll();
	
	public Reader findById(Integer id)throws Exception;
	
	public void saveOrUpdate(Reader reader)throws Exception;
	
	public void deleteById(Integer id)throws Exception;
	
	public void addToBookShelf (Integer reader_id,Integer article_id);
	
	public void addBookMark(Integer reader_id,Integer chapter_id);
	
	public void commentaryArticle(Integer reader_id,Comment comment);
}
