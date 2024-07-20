package com.coding.controladores;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.modelos.Dojo;
import com.coding.modelos.Ninja;
import com.coding.servicios.ServiciosDojo;
import com.coding.servicios.ServiciosNinjas;

import jakarta.validation.Valid;

@Controller
public class ControladorNinja {
	
	private final ServiciosNinjas servicioNinja;
	private final ServiciosDojo servicioDojos;
	
	public ControladorNinja(ServiciosNinjas servicioNinja, ServiciosDojo servicioDojos) {
		super();
		this.servicioNinja = servicioNinja;
		this.servicioDojos = servicioDojos;
	}

	@GetMapping("/ninjas/new")
	public String agregaNinja(@ModelAttribute("ninjas") Ninja ninjas) {
		return "formularioNinja.jsp";
	}
	
	 @PostMapping("/agrega/ninja")
	    public String agregaNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult validaciones, @RequestParam("dojoId") Long dojoId) {
	        if (validaciones.hasErrors()) {
	            return "formularioNinja.jsp";
	        }

	        Dojo dojo = servicioDojos.obtenerPorId(dojoId);
	        ninja.setDojo(dojo);
	        servicioNinja.insertarNinja(ninja);
	        return "redirect:/ninjas/new";
	    }
	 
	
}

