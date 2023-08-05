package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pagos")
public class Pago {
	private int id;
	private int cliente_id;
	private float monto;
	private LocalDate fecha_pago;

	public Pago() {
	}

	public Pago(int id, int cliente_id, float monto, LocalDate fecha_pago) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.monto = monto;
		this.fecha_pago = fecha_pago;
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

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public LocalDate getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", cliente_id=" + cliente_id + ", monto=" + monto + ", fecha_pago=" + fecha_pago
				+ "]";
	}

}
