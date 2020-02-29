package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	@Query(value="select c.id from cms_category c where c.name=?1",nativeQuery=true)
	public Integer findIdByName(String name);
}
