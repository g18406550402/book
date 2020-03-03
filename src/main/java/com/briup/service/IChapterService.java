package com.briup.service;


import com.briup.bean.Chapter;


public interface IChapterService {
	public void saveOrUpdate(Chapter chapter)throws Exception;
	public void deleteById(Integer id)throws Exception;
	public Chapter findById(Integer id)throws Exception;
}
