package com.coding.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.modelos.Product;
import com.coding.servicios.ServicioProduct;

public class ControladorProduct {

	@Autowired
	private final ServicioProduct servicioProducto;

	public ControladorProduct(ServicioProduct servicioProducto) {
		super();
		this.servicioProducto = servicioProducto;
	}
	
	@GetMapping("/products/new")
	public String formularioProduct() {
		return "agregaProducto.jsp";
	}
	@PostMapping("/products/new")
	public String agregaProducto(@ModelAttribute("product") Product product) {
		
		servicioProducto.actualizarProduct(product);
		return "agregaProducto.jsp";
	}
}
