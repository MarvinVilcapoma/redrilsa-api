package com.aplicacion.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aplicacion.app.entities.Proyecto;
import com.aplicacion.app.services.ProyectoService;

@RestController
public class ProyectoController {
	
private static final Logger logger = LoggerFactory.getLogger(ProyectoController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/proyectos")
	public List<Proyecto> proyectos() {
		logger.info("call proyectos");
		
		List<Proyecto> proyectos = proyectoService.findAll();
		logger.info("proyectos: " + proyectos);
		
		return proyectos;
	}
	@GetMapping("/proyectos/{id}")
	public Proyecto obtenerID(@PathVariable Long id) {
		logger.info("call obtener:"+id);
		Proyecto pro=proyectoService.findById(id);
				
		return pro;
		
	}
	@GetMapping("/proyectos/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		logger.info("call images: " + filename);
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		logger.info("Path: " + path);
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
		logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}
	@PostMapping("/proyectos")
	public Proyecto crear(@RequestParam(name="imagen", required=false) MultipartFile imagen, 
			@RequestParam("nombre") String nombre,@RequestParam("cliente") String cliente,
			@RequestParam("distrito") String distrito,@RequestParam("provincia") String provincia,
			@RequestParam("departamento") String departamento,@RequestParam("gerente") String gerente,
			@RequestParam("telefono")String telefono) throws Exception {
		logger.info("call crear(" + nombre + ","+cliente+","+distrito+","+provincia+","+departamento+","+gerente+","+telefono+", " + imagen + ")");
		
		Proyecto pro = new Proyecto();
		pro.setNombre(nombre);
		pro.setCliente(cliente);
		pro.setDistrito(distrito);
		pro.setProvincia(provincia);
		pro.setDepartamento(departamento);
		pro.setGerente(gerente);
		pro.setTelefono(telefono);
		
		
		
		if (imagen != null && !imagen.isEmpty()) {
			String filename = System.currentTimeMillis() + imagen.getOriginalFilename().substring(imagen.getOriginalFilename().lastIndexOf("."));
			pro.setImagen(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(imagen.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		proyectoService.save(pro);
		
		return pro;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id) {
		logger.info("call eliminar: " + id);
		
		proyectoService.deleteById(id);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}


}
