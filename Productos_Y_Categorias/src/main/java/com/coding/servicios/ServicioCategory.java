package com.coding.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coding.modelos.Category;
import com.coding.repositorios.RepositorioCategory;

public class ServicioCategory {

	@Autowired
	private final RepositorioCategory repositorioCategory;

	public ServicioCategory(RepositorioCategory repositorioCategory) {
		super();
		this.repositorioCategory = repositorioCategory;
	}
	
	public Category agregarCategory(Category nuevaCategory) {
		return this.repositorioCategory.save(nuevaCategory);
	}
	
	public List<Category> obtenerTodasCategory(){
		return this.repositorioCategory.findAll();
	}
	
	public Category obtenerPorId(Long id) {
		return this.repositorioCategory.findById(id).orElse(null);
	}
	
	public void eliminarPorId(Long id) {
		this.repositorioCategory.deleteById(id);
	}
	
	public Category actualizarCategory(Category category) {
		return this.repositorioCategory.save(category);
	}
}
