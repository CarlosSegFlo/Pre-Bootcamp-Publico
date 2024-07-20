package com.coding.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.modelos.Dojo;
import com.coding.repositorios.RepositorioDojo;

@Service
public class ServiciosDojo {
	
	@Autowired
	private final RepositorioDojo repositorioDojo;

	
	
	public ServiciosDojo(RepositorioDojo repositorioDojo) {
		super();
		this.repositorioDojo = repositorioDojo;
	}

	public Dojo insertarDojos(Dojo nuevoDojos) {
		return this.repositorioDojo.save(nuevoDojos);
	}
	
	public List<Dojo> obtenerTodas(){
		return this.repositorioDojo.findAll();
	}
	
	public Dojo obtenerPorId(Long id) {
		return this.repositorioDojo.findById(id).orElse(null);
	}
	
	public void eliminarPorId(Long id) {
		this.repositorioDojo.deleteById(id);
	}
	
	
}
