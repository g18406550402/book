package com.briup.service;

import java.util.List;

import com.briup.bean.Comment;

public interface ICommentService {
	public List<Comment> findAll();
	
	public Comment findById(Integer id)throws Exception;
	
	public void saveOrUpdate(Comment comment)throws Exception;
	
	public void deleteById(Integer id)throws Exception;
	
	
}
