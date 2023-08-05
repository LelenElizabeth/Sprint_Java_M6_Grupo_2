package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accidentes")

public class Accidente {
	@Id
	@Column(name="id")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id",referencedColumnName="id",insertable = false, updatable = false) 	
	private Cliente cliente;
	private LocalDate fecha_accidente;
	private String detalle;

	public Accidente() {
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

	public LocalDate getFecha_accidente() {
		return fecha_accidente;
	}

	public void setFecha_accidente(LocalDate fecha_accidente) {
		this.fecha_accidente = fecha_accidente;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Accidente [id=" + id + ", cliente=" + cliente + ", fecha_accidente=" + fecha_accidente + ", detalle="
				+ detalle + "]";
	}
	

}
