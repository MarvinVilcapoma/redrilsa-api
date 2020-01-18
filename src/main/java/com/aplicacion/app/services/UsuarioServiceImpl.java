package com.aplicacion.app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.app.entities.Usuario;
import com.aplicacion.app.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		
		return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
		
	}

}
