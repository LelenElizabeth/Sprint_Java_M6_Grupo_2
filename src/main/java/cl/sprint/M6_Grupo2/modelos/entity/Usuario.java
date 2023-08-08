package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombreUsuario;
	@Column(name="contrasena")
	private String contraseña;
	@Enumerated(EnumType.STRING)
	private RolUsuario rol;
	
	public Usuario() {}
	
	public Usuario(int id) {
		super();
		this.id = id;
		
	}
	
	public Usuario(int id, String nombreUsuario) {
		super();
		this.id = id;
		this.nombreUsuario=nombreUsuario;
	}
	

	public Usuario(int id, String nombreUsuario, RolUsuario rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;
	}

	public Usuario(String nombreUsuario, String contraseña, RolUsuario rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña= contraseña;
		this.rol = rol;
	}
	
	public Usuario(int id, String nombreUsuario, String contraseña, RolUsuario rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contraseña= contraseña;
		this.rol = rol;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombreUsuario;
	}
	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public RolUsuario getRol() {
		return rol;
	}
	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", rol=" + rol + ", contraseña=" + contraseña + "]";
	}
	
}
