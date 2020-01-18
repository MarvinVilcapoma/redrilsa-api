package com.aplicacion.app.services;

import java.util.List;

import com.aplicacion.app.entities.MaquinaSup;

public interface MaquinaSupService {
	
	
	public List<MaquinaSup>findAll();
	public MaquinaSup findById(Long id_sup);
	public void save(MaquinaSup maquinasup);	
	public void deleteById(Long id_sup);
	
}
