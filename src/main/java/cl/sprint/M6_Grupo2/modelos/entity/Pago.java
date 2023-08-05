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
@Table(name="pagos")
public class Pago {
	@Id
	@Column(name="id")
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id", referencedColumnName="id",insertable = false, updatable = false) 
	private Cliente cliente;
	private float monto;
	private LocalDate fecha_pago;

	public Pago() {
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
		return "Pago [id=" + id + ", cliente=" + cliente + ", monto=" + monto + ", fecha_pago=" + fecha_pago + "]";
	}
	

}
