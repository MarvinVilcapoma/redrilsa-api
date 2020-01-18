package com.aplicacion.app.services;

import java.util.List;

import com.aplicacion.app.entities.MaquinaIm;

public interface MaquinaImService {
	
	public List<MaquinaIm>findAll();
	public MaquinaIm findById(Long id_im);
	public void save(MaquinaIm maquinaim);	
	public void deleteById(Long id_im);
	
	

}
