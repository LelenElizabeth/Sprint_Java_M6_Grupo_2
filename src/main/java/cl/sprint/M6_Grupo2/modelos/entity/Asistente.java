package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="asesorias")
public class Asistente {
	private int capacitacion_id;
	private int usuario_id;

	public Asistente() {
	}

	public Asistente(int capacitacion_id, int usuario_id) {
		super();
		this.capacitacion_id = capacitacion_id;
		this.usuario_id = usuario_id;
	}

	public int getCapacitacion_id() {
		return capacitacion_id;
	}

	public void setCapacitacion_id(int capacitacion_id) {
		this.capacitacion_id = capacitacion_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Override
	public String toString() {
		return "Asistente [capacitacion_id=" + capacitacion_id + ", usuario_id=" + usuario_id + "]";
	}

}
