package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="profesional")
@PrimaryKeyJoinColumn(name = "id")
public class Profesional extends Usuario {


	@Column(name="nombre_p")
	private String nombrePro;
	private String titulo;
	@Column(name="fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profesional_id")
    private List<Visitas> visitas = new ArrayList<>();
	public Profesional() {
	}

	
	public Profesional(int id, String nombreUsuario, String nombrePro, String titulo, LocalDate fechaIngreso) {
		super(id, nombreUsuario);
		this.nombrePro = nombrePro;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}


	public Profesional(int id, String nombreUsuario, String contraseña, String nombre, String titulo,
			LocalDate fechaIngreso) {
		super(id, nombreUsuario,contraseña,RolUsuario.Profesional);
		this.nombrePro = nombre;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Profesional( String nombreUsuario, String contraseña, String nombre, String titulo,
			LocalDate fechaIngreso) {
		super(nombreUsuario,contraseña,RolUsuario.Profesional);
		this.nombrePro = nombre;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombre) {
		this.nombrePro = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String obtenerFechaFormat() {
		String fechaIngresoFormateada = "";
		if(fechaIngreso != null) {
			DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			fechaIngresoFormateada = fechaIngreso.format(formatoSalida);
		}
		return fechaIngresoFormateada;
	}
	@Override
	public String toString() {
		return super.toString()+" [nombre=" + nombrePro + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}
	

}
