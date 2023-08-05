package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asesorias")

public class Asesoria {
	@Id
	@Column(name="id")
	private int id;
	private String nombre;
	private String detalle;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profesional_id",referencedColumnName="id",insertable = false, updatable = false)
	private Profesional profesional;

	public Asesoria() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "Asesoria [id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + ", profesional=" + profesional
				+ "]";
	}
	

}
