package com.aplicacion.app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.app.entities.MaquinaSup;
import com.aplicacion.app.repositories.MaquinaSupRepository;

@Service
@Transactional
public class MaquinaSupServiceImpl implements MaquinaSupService{

	@Autowired
	private MaquinaSupRepository maquinasupRepository;
	
	@Override
	public List<MaquinaSup> findAll() {
		return maquinasupRepository.findAll();
	}

	@Override
	public MaquinaSup findById(Long id_sup) {
		return maquinasupRepository.findById(id_sup).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(MaquinaSup maquinasup) {
		maquinasupRepository.save(maquinasup);
		
	}

	@Override
	public void deleteById(Long id_sup) {
		maquinasupRepository.deleteById(id_sup);
		
	}
	

}
