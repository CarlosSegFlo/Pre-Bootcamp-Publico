package com.coding.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.modelos.Dojo;
import com.coding.modelos.Ninja;

@Repository
public interface RepositorioNinjas extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	List<Ninja> findByDojos(Dojo dojo);
}
