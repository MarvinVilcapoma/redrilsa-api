package com.aplicacion.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="maquinas_sup")
public class MaquinaSup {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_sup;
	private String nombre_sup;
	private String observacion;
	private Long proyecto_id;
	
	
	public Long getId_sup() {
		return id_sup;
	}
	public void setId_sup(Long id_sup) {
		this.id_sup = id_sup;
	}
	public String getNombre_sup() {
		return nombre_sup;
	}
	public void setNombre_sub(String nombre_sup) {
		this.nombre_sup = nombre_sup;
	}
	
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Long getProyecto_id() {
		return proyecto_id;
	}
	public void setProyecto_id(Long proyecto_id) {
		this.proyecto_id = proyecto_id;
	}
	@Override
	public String toString() {
		return "MaquinaSup [id_sup=" + id_sup + ", nombre_sup=" + nombre_sup + ", observacion=" + observacion
				+ ", proyecto_id=" + proyecto_id + "]";
	}
	
	
	
}
