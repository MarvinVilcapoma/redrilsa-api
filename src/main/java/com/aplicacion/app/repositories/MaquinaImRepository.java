package com.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplicacion.app.entities.MaquinaIm;

public interface MaquinaImRepository extends CrudRepository<MaquinaIm,Long>{
	
	List<MaquinaIm>findAll();
}
