package com.aplicacion.app.services;

import java.util.List;

import com.aplicacion.app.entities.Proyecto;

public interface ProyectoService {
	
	public List<Proyecto> findAll();
	
	public Proyecto findById(Long id);
	
	public void save(Proyecto proyecto);
	
	public void deleteById(Long id);

	
}
