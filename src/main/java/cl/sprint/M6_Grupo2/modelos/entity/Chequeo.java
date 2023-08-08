package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chequeos")
public class Chequeo {
	@Id
	@Column(name="id")
	private int id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="visita_id",referencedColumnName="id",insertable = false, updatable = false) 
	private Visitas visitas;
	private String detalle;
	private Estado estado;

	public Chequeo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Visitas getVisita() {
		return visitas;
	}

	public void setVisita(Visitas visitas) {
		this.visitas = visitas;
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
		return "Chequeo [id=" + id + ", visita=" + visitas + ", detalle=" + detalle + ", estado=" + estado + "]";
	}
	
}
