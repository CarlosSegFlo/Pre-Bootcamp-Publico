package com.coding.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.modelos.Dojo;

@Repository
public interface RepositorioDojo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
