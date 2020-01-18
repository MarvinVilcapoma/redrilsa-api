package com.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplicacion.app.entities.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto,Long>{
	
	List<Proyecto>findAll();
}
