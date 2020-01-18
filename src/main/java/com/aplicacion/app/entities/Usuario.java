package com.aplicacion.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String nombre;
	private String cargo;
	private String correo;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_id",referencedColumnName="id")
	private List<Proyecto> proyecto=new ArrayList<>();
	
	public List<Proyecto> getProyecto() {
		return proyecto;
	}
	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", cargo=" + cargo + ", correo=" + correo
				+ ", password=" + password + ", proyecto=" + proyecto + "]";
	}
	
	

}
