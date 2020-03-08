package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Reader;

public interface ReaderDao extends JpaRepository<Reader, Integer> {
	
}
