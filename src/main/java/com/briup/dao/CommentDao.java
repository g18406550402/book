package com.briup.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {
	
}
