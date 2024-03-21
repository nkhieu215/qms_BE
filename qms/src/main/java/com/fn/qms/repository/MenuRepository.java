package com.fn.qms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findAll();
	
	@Query("From Menu where parentId is null order by order asc")
	List<Menu> getMenuParent();
}