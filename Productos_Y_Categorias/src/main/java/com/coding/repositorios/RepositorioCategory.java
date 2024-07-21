package com.coding.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.modelos.Category;

public interface RepositorioCategory extends CrudRepository<Category, Long>{
	List<Category> findAll();
}
