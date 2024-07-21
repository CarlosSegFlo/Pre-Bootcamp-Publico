package com.coding.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.modelos.Category;
import com.coding.modelos.Product;
import com.coding.servicios.ServicioCategory;
import com.coding.servicios.ServicioProduct;

import jakarta.validation.Valid;

public class ControladorCategory {
	
	@Autowired
	private final ServicioProduct servicioProduct;
	private final ServicioCategory servicioCategory;
	
	public ControladorCategory(ServicioProduct servicioProducto, ServicioCategory servicioCategory) {
		super();
		this.servicioProduct = servicioProducto;
		this.servicioCategory = servicioCategory;
	}
	
	@GetMapping("/categories/new")
	public String agregaCategoria(Model model) {
		model.addAttribute("categoria", new Category());
		return "formularioCategoria.jsp";
	}
	
	@PostMapping("/categories")
    public String agregaCategoria(@Valid @ModelAttribute("categoria") Category categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "formularioCategoria.jsp";
        }
        servicioCategory.agregarCategory(categoria);
        return "redirect:/categories/new";
    }
	
	@GetMapping("/categories")
    public String mostrarCategorias(Model model) {
        model.addAttribute("categorias", servicioCategory.obtenerTodasCategory());
        model.addAttribute("productos", servicioProduct.obtenerTodasProduct());
        return "listadoCategorias.jsp";
    }

    @PostMapping("/categories/add-producto")
    public String agregarProductoACategoria(@RequestParam Long categoriaId, @RequestParam Long productoId) {
        Category categoria = servicioCategory.obtenerPorId(categoriaId);
        Product producto = servicioProduct.obtenerPorId(productoId);

        if (categoria != null && producto != null) {
            categoria.getProducts().add(producto);
            servicioCategory.agregarCategory(categoria);
        }
        return "redirect:/categorias";
    }
}
