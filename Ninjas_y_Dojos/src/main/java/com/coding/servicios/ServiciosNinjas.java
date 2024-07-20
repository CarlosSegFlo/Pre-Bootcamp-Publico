package com.coding.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.modelos.Dojo;
import com.coding.modelos.Ninja;
import com.coding.repositorios.RepositorioNinjas;

@Service
public class ServiciosNinjas {
	@Autowired
	private final RepositorioNinjas repositorioNinjas;
	
	public ServiciosNinjas(RepositorioNinjas repositorioNinjas) {
		this.repositorioNinjas = repositorioNinjas;
	}

	public Ninja insertarNinja(Ninja nuevaNinja) {
		return this.repositorioNinjas.save(nuevaNinja);
	}
	
	public List<Ninja> obtenerTodas(){
		return this.repositorioNinjas.findAll();
	}
	
	public Ninja obtenerPorId(Long id) {
		return this.repositorioNinjas.findById(id).orElse(null);
	}
	
	public List<Ninja> obtenerPorDojo(Dojo dojo){
		return this.repositorioNinjas.findByDojos(dojo);
	}
}
