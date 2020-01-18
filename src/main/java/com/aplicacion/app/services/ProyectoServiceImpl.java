package com.aplicacion.app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.app.entities.Proyecto;
import com.aplicacion.app.repositories.ProyectoRepository;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public List<Proyecto> findAll() {
		return proyectoRepository.findAll();
	}

	@Override
	public Proyecto findById(Long id) {
		return proyectoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
		
	}

	@Override
	public void deleteById(Long id) {
		proyectoRepository.deleteById(id);
		
	}

}
