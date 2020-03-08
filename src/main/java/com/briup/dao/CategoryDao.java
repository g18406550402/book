package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.briup.bean.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	@Query(value="select c.id from cms_category c where c.name=?1",nativeQuery=true)
	public Integer findIdByName(String name);
	
	@Query(value="select c.name from cms_category c where c.id=?1",nativeQuery=true)
	public String findNameById(Integer id);
	
	@Transactional
	@Modifying
	@Query(value="delete from cms_category where id= ?1",nativeQuery=true)
	public void deleteById(Integer id);
}
