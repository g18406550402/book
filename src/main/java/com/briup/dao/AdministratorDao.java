package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Administrator;

public interface AdministratorDao extends JpaRepository<Administrator, Integer> {

}
