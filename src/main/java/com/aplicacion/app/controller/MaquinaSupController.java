package com.aplicacion.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aplicacion.app.entities.MaquinaSup;
import com.aplicacion.app.services.MaquinaSupService;

@RestController
public class MaquinaSupController {
	
	@Autowired
	private MaquinaSupService maquinasupService;
	
	@GetMapping("/maquinas/superficie")
	public List<MaquinaSup> listaMaquinaSup() {
		
	List<MaquinaSup> maquinasup = maquinasupService.findAll();
	return maquinasup;
	
	}
	@GetMapping("/maquinas/superficie/{id_sup}")
	public MaquinaSup obtenerID(@PathVariable Long id_sup) {
		MaquinaSup sup=maquinasupService.findById(id_sup);
		return sup;
	}
	@PostMapping("/maquinas/superficie")
	public MaquinaSup crear(@RequestParam("nombre_sup") String nombre_sup) throws Exception {
		
		MaquinaSup sup = new MaquinaSup();
		sup.setNombre_sub(nombre_sup);
		maquinasupService.save(sup);
		return sup;
	}
	@DeleteMapping("/maquinas/superficie/{id_sup}")
	public ResponseEntity<String> eliminar(@PathVariable Long id_sup) {

		maquinasupService.deleteById(id_sup);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
		
}
