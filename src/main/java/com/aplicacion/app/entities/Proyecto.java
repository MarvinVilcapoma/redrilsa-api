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
@Table(name = "proyecto") 
public class Proyecto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nombre;
		private String cliente;
		private String distrito;
		private String provincia;
		private String departamento;
		private String gerente;
		private String telefono;
		private String imagen;
		private Long usuario_id;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="proyecto_id",referencedColumnName="id")
		private List<MaquinaIm>maquinaim=new ArrayList<>();
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="proyecto_id",referencedColumnName="id")
		private List<MaquinaSup>maquinasup=new ArrayList<>();
		
		
		public List<MaquinaSup> getMaquinasup() {
			return maquinasup;
		}

		public void setMaquinasup(List<MaquinaSup> maquinasup) {
			this.maquinasup = maquinasup;
		}

		public List<MaquinaIm> getMaquinaim() {
			return maquinaim;
		}

		public void setMaquinaim(List<MaquinaIm> maquinaim) {
			this.maquinaim = maquinaim;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCliente() {
			return cliente;
		}

		public void setCliente(String cliente) {
			this.cliente = cliente;
		}

		public String getDistrito() {
			return distrito;
		}

		public void setDistrito(String distrito) {
			this.distrito = distrito;
		}

		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}

		public String getDepartamento() {
			return departamento;
		}

		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		public String getGerente() {
			return gerente;
		}

		public void setGerente(String gerente) {
			this.gerente = gerente;
		}

		
		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public Long getUsuario_id() {
			return usuario_id;
		}

		public void setUsuario_id(Long usuario_id) {
			this.usuario_id = usuario_id;
		}

		@Override
		public String toString() {
			return "Proyecto [id=" + id + ", nombre=" + nombre + ", cliente=" + cliente + ", distrito=" + distrito
					+ ", provincia=" + provincia + ", departamento=" + departamento + ", gerente=" + gerente
					+ ", telefono=" + telefono + ", imagen=" + imagen + ", usuario_id=" + usuario_id + ", maquinaim="
					+ maquinaim + ", maquinasup=" + maquinasup + "]";
		}

		

		
		
}
