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

public class ControladorProduct {

	@Autowired
	private final ServicioProduct servicioProducto;
	private final ServicioCategory servicioCategory;
	
	public ControladorProduct(ServicioProduct servicioProducto, ServicioCategory servicioCategory) {
		super();
		this.servicioProducto = servicioProducto;
		this.servicioCategory = servicioCategory;
	}

	@GetMapping("/product/new")
    public String showProductoForm(Model model) {
        model.addAttribute("producto", new Product());
        return "formularioProducto.jsp";
    }

    @PostMapping("/product")
    public String createProducto(@Valid @ModelAttribute("producto") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "formularioProducto.jsp";
        }
        servicioProducto.agregarProduct(product);
        return "redirect:/productos";
    }
    
    @GetMapping("/product")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", servicioProducto.obtenerTodasProduct());
        model.addAttribute("categorias", servicioCategory.obtenerTodasCategory());
        return "listadoProductos.jsp";
    }

    @PostMapping("/product/add-categories")
    public String agregarCategoriaAProducto(@RequestParam Long productoId, @RequestParam Long categoriaId) {
        Product producto = servicioProducto.obtenerPorId(productoId);
        Category categoria = servicioCategory.obtenerPorId(categoriaId);

        if (producto != null && categoria != null) {
            producto.getCategories().add(categoria);
            servicioProducto.agregarProduct(producto);
        }
        return "redirect:/productos";
    }
}
