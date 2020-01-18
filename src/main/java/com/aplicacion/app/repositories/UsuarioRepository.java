package com.aplicacion.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplicacion.app.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
	
	List<Usuario>findAll();
}
