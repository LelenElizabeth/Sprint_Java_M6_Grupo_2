package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cl.sprint.M6_Grupo2.utils.ValidarDatos;

@Entity
@Table(name = "visitas")
public class Visitas {

	@Id
	@Column(name = "id")
	private int id;
	//@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "rut_cliente", referencedColumnName = "rut")
	int  rut_cliente;
	private LocalDateTime fecha_hora;
	private String lugar;
	private String comentarios;
	//@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "profesional_id", referencedColumnName = "id")
	int profesional_id;

	public Visitas() {
	}

	public Visitas(int id, int rut_cliente, LocalDateTime fecha_hora, String lugar, String comentarios,
			int profesional_id) {
		super();
		this.id = id;
		this.rut_cliente = rut_cliente;
		this.fecha_hora = fecha_hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
		this.profesional_id = profesional_id;
	}

	public Visitas(int rut_cliente, LocalDateTime fecha_hora, String lugar, String comentarios, int profesional_id) {
		super();
		this.rut_cliente = rut_cliente;
		this.fecha_hora = fecha_hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
		this.profesional_id = profesional_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRut_cliente() {
		return rut_cliente;
	}

	public void setRut_cliente(int rut_cliente) {
		this.rut_cliente = rut_cliente;
	}

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getProfesional_id() {
		return profesional_id;
	}

	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}

	

}
