package com.coding.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.modelos.Dojo;
import com.coding.modelos.Ninja;
import com.coding.servicios.ServiciosDojo;

@Controller
public class ControladorDojos {
	
    private final ServiciosDojo servicioDojos;

    public ControladorDojos(ServiciosDojo servicioDojos) {
        this.servicioDojos = servicioDojos;
    }

    @GetMapping("/dojos/new")
    public String agregaDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "formularioDojo.jsp";
    }

    @PostMapping("/agregar/dojo")
    public String agregarDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "formularioDojo.jsp";
        }
        servicioDojos.insertarDojos(dojo);
        return "redirect:/dojos/new";
    }

    @GetMapping("/dojos/{id}")
    public String desplegarInfoDojos(@PathVariable("id") Long id, Model modelo) {
        Dojo dojo = servicioDojos.obtenerPorId(id);
           	List<Ninja> listaDeNinjas = dojo.getNinjas();
            modelo.addAttribute("dojo", dojo);
            modelo.addAttribute("ninjas", listaDeNinjas);
     
        return "tablaDojosNinjas.jsp";
    }
}
