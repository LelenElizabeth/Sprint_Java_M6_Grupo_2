package cl.sprint.M6_Grupo2.modelos.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario  implements Serializable {
	private String nombres;
	private String apellidos;
	private int telefono;
	private String direccion;
	private String comuna;
	private int edad;
	private int rut;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Visitas> visitas;
	
	public Cliente() {
		super();
	}
	
	public Cliente(int id) {
		super(id);
	}
	
	
	public Cliente(int id, String nombreUsuario, String contraseña, RolUsuario tipo) {
		super(id,nombreUsuario,contraseña,tipo);
	}
	
	public Cliente(int id, String nombreUsuario, String nombres, String apellidos, int telefono, String direccion,
			String comuna, int edad, int rut) {
		super(id, nombreUsuario, RolUsuario.Cliente);
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		this.rut = rut;
	}

	public Cliente(int id, String nombreUsuario,String contraseña, String nombres, String apellidos, int telefono, String direccion,
			String comuna, int edad, int rut) {
		super(id, nombreUsuario,contraseña, RolUsuario.Cliente);
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		this.rut = rut;
	}

	public Cliente(String nombreUsuario,String contraseña, String nombres, String apellidos, int telefono, String direccion,
			String comuna, int edad, int rut) {
		super( nombreUsuario,contraseña, RolUsuario.Cliente);
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		this.rut = rut;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return super.toString() + " [nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", comuna=" + comuna + ", edad=" + edad + ", rut=" + rut + "]";
	}

}
