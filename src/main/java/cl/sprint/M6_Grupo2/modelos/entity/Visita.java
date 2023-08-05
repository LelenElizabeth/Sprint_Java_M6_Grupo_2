package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="visitas")
public class Visita {
	@Id
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id",referencedColumnName="id",insertable = false, updatable = false) 
	private Cliente cliente;
	private LocalDate fecha_visita;
	private String detalle;
	private int profesional_id;

	public Visita() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(LocalDate fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getProfesional_id() {
		return profesional_id;
	}

	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}


}
