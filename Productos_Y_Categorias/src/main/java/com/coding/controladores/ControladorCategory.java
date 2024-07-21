package com.coding.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.modelos.Category;
import com.coding.servicios.ServicioCategory;

public class ControladorCategory {
	
	@Autowired
	private final ServicioCategory servicioCategory;

	public ControladorCategory(ServicioCategory servicioCategory) {
		super();
		this.servicioCategory = servicioCategory;
	}
	
	@GetMapping("/categories/new")
	public String formularioCategoria() {
		return "agregaCategoria.jsp";
	}
	
	@PostMapping("/categories/new")
	public String agregaCategoria(@ModelAttribute("category") Category category) {
		
		servicioCategory.agregarCategory(category);
		return "agregaCategoria.jsp";
	}
}
