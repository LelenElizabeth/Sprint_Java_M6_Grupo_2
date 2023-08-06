package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDateTime;

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
	@JoinColumn(name="cliente_id", referencedColumnName="id") 
	private Cliente cliente;
	private float monto;
	@Column(name="fecha_pago")
	private LocalDateTime fechaPago;

	public Pago() {
	}
	
	public Pago( Cliente cliente, float monto, LocalDateTime fechaPago) {
		super();
		this.cliente = cliente;
		this.monto = monto;
		this.fechaPago = fechaPago;
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

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", cliente=" + cliente + ", monto=" + monto + ", fechaPago=" + fechaPago + "]";
	}
	

}
