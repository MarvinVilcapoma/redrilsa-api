package com.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.aplicacion.app.entities.MaquinaSup;

public interface MaquinaSupRepository extends CrudRepository<MaquinaSup,Long> {
	
	List<MaquinaSup>findAll();
}
