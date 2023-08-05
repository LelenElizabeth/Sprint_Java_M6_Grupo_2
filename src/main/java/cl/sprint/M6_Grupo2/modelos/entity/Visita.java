package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="visitas")
public class Visita {
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id",referencedColumnName="id") Cliente cliente;
	private int cliente_id;
	private LocalDate fecha_visita;
	private String detalle;
	private int profesional_id;

	public Visita() {
	}

	public Visita(int id, int cliente_id, LocalDate fecha_visita, String detalle, int profesional_id) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.fecha_visita = fecha_visita;
		this.detalle = detalle;
		this.profesional_id = profesional_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
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

	@Override
	public String toString() {
		return "Visita [id=" + id + ", cliente_id=" + cliente_id + ", fecha_visita=" + fecha_visita + ", detalle="
				+ detalle + ", profesional_id=" + profesional_id + "]";
	}

}
