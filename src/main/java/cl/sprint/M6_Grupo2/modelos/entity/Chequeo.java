package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chequeos")
public class Chequeo {
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="visita_id",referencedColumnName="id") Visita visita;
	private int visita_id;
	private String detalle;
	private Estado estado;

	public Chequeo() {
	}

	public Chequeo(int id, int visita_id, String detalle, Estado estado) {
		super();
		this.id = id;
		this.visita_id = visita_id;
		this.detalle = detalle;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVisita_id() {
		return visita_id;
	}

	public void setVisita_id(int visita_id) {
		this.visita_id = visita_id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Chequeo [id=" + id + ", visita_id=" + visita_id + ", detalle=" + detalle + ", estado=" + estado + "]";
	}

}
