package com.aplicacion.app.services;

import org.springframework.stereotype.Service;

import com.aplicacion.app.entities.Usuario;
import com.aplicacion.app.repositories.AuthenticationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class AuthenticationService {
	
private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
    private AuthenticationRepository authenticationRepository;
	
	public Usuario login(String correo, String password) throws Exception {
		logger.info("login("+correo+", "+password+")");
        return authenticationRepository.login(correo, password);
    }
	
	public Usuario findByUsername(String correo) throws EmptyResultDataAccessException{
		logger.info("findByUsername("+correo+")");
		return authenticationRepository.findByUsername(correo);
	}

}
