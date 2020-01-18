package com.aplicacion.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.app.entities.Usuario;
import com.aplicacion.app.services.UsuarioService;

@RestController
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		logger.info("call usuarios");
		List<Usuario> usuarios = usuarioService.findAll();
		logger.info("usuarios"+usuarios);
		return usuarios;
	}
	@GetMapping("/usuarios/{id}")
	public Usuario obtenerID(@PathVariable Long id) {
		
		Usuario usu=usuarioService.findById(id);
		return usu;
		
	}
	@PostMapping("/usuarios")
	public Usuario crear(@RequestParam("nombre") String nombre,
			@RequestParam("dni")String dni,
			@RequestParam("cargo")String  cargo,
			@RequestParam("correo")String correo,
			@RequestParam("password")String password) throws Exception {
		
		Usuario usu = new Usuario();
		usu.setNombre(nombre);
		usu.setDni(dni);
		usu.setCargo(cargo);
		usu.setCorreo(correo);
		usu.setPassword(password);
		usuarioService.save(usu);
		return usu;
	}

	
	
	
}
