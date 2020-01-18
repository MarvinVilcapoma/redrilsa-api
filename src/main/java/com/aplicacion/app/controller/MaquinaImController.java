package com.aplicacion.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.app.entities.MaquinaIm;
import com.aplicacion.app.services.MaquinaImService;

@RestController
public class MaquinaImController {
	
	@Autowired
	private MaquinaImService maquinaimService;
	
	@GetMapping("/maquinas/mina")
	public List<MaquinaIm> listamaquinaIM() {		
		List<MaquinaIm> maquinaim = maquinaimService.findAll();
		return maquinaim;
	}
	@GetMapping("/maquinas/mina/{id_im}")
	public MaquinaIm obteneID(@PathVariable Long id_im) {
		MaquinaIm im= maquinaimService.findById(id_im);
		return im;
		
	}
	@PostMapping("/maquinas/mina")
	public MaquinaIm crear(@RequestParam("nombre_im") String nombre_im,@RequestParam("fecha_inicio")Date fecha_inicio,
			@RequestParam("placa")String placa,@RequestParam("serie_motor")Integer serie_motor,
			@RequestParam("lectura_horometro")Integer lectura_horometro,@RequestParam("observacion") String observacion) throws Exception {
		
		MaquinaIm im = new MaquinaIm();
		im.setNombre_im(nombre_im);
		im.setFecha_inicio(fecha_inicio);
		im.setPlaca(placa);
		im.setSerie_motor(serie_motor);
		im.setLectura_horometro(lectura_horometro);
		im.setObservacion(observacion);
		maquinaimService.save(im);
		return im;
	}
	@DeleteMapping("/maquinas/mina/{id_im}")
	public ResponseEntity<String> eliminar(@PathVariable Long id_im) {

		maquinaimService.deleteById(id_im);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
		

}
