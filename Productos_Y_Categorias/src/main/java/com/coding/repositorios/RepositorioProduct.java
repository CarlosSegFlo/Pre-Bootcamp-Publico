package com.coding.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.modelos.Product;

public interface RepositorioProduct extends CrudRepository<Product, Long>{
	List<Product> findAll();

	Product getByNombre(String nombre);
}
