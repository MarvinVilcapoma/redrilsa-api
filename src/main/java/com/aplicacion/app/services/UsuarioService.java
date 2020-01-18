package com.aplicacion.app.services;

import java.util.List;

import com.aplicacion.app.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public void save(Usuario usuario);
	
	public void deleteById(Long id);


}
