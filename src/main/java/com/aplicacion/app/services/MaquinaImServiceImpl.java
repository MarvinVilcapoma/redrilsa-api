package com.aplicacion.app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.app.entities.MaquinaIm;
import com.aplicacion.app.repositories.MaquinaImRepository;

@Service
@Transactional
public class MaquinaImServiceImpl implements MaquinaImService {
	
	@Autowired
	private MaquinaImRepository maquinaimRepository;
	

	@Override
	public List<MaquinaIm> findAll() {
		return maquinaimRepository.findAll();
	}

	@Override
	public MaquinaIm findById(Long id_im) {
		return maquinaimRepository.findById(id_im).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(MaquinaIm maquinaim) {
		maquinaimRepository.save(maquinaim);
		
	}

	@Override
	public void deleteById(Long id_im) {
		maquinaimRepository.deleteById(id_im);
		
	}

}
