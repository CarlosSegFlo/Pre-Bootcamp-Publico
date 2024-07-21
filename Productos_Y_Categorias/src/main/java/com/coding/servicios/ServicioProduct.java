package com.coding.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coding.modelos.Product;
import com.coding.repositorios.RepositorioProduct;

public class ServicioProduct {
	
	@Autowired
	private final RepositorioProduct repositorioProduct;

	public ServicioProduct(RepositorioProduct repositorioProduct) {
		super();
		this.repositorioProduct = repositorioProduct;
	}
	
	public Product agregarProduct(Product nuevaProduct) {
		return this.repositorioProduct.save(nuevaProduct);
	}
	
	public List<Product> obtenerTodasProduct(){
		return this.repositorioProduct.findAll();
	}
	
	public Product obtenerPorId(Long id) {
		return this.repositorioProduct.findById(id).orElse(null);
	}
	
	public void eliminarPorId(Long id) {
		this.repositorioProduct.deleteById(id);
	}
	
	public Product actualizarProduct(Product cancion) {
		return this.repositorioProduct.save(cancion);
	}

	public Product obtenerPorNombre(String nombre) {
		return this.repositorioProduct.getByNombre(nombre);
	}
}
