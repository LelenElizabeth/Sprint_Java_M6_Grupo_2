package cl.sprint.M6_Grupo2.modelos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cl.sprint.M6_Grupo2.utils.ValidarDatos;


@Entity
@Table(name="Capacitaciones")
public class Capacitacion {

	@Id
	@Column(name="Id")
	private int Id;
	private String nombre;
	private String detalle;
	@Column(name="rut_cliente")
	private int rut_cliente ;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	@Column(name="cantidad_asistentes")
	private int cantidad_asistentes;

	
	public Capacitacion() {
	}
	//Constructor formulario
	public Capacitacion(String nombre, String detalle, int rut_cliente, String dia, String hora, String lugar,
			String duracion, int cantidad_asistentes) {
		super();
		setNombre(nombre);
		setDetalle(detalle);
		setRutCliente(rut_cliente);
		setDia(dia);
		setHora(hora);
		setLugar(lugar);
		setDuracion(duracion);
		setCantidadAsistentes(cantidad_asistentes);
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		if(ValidarDatos.esObligatorio(String.valueOf(id))) {
			this.Id = id;			
		}
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(ValidarDatos.RangoCaracteres(nombre, 5, 100)) {
			this.nombre = nombre;
		}
	}

	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		if(ValidarDatos.RangoCaracteres(detalle, 5, 100)) {
			this.detalle = detalle;
		}
	}

	public int getRutCliente() {
		return rut_cliente;
	}

	public void setRutCliente(int rutCliente) {
		if(ValidarDatos.esObligatorio(String.valueOf(rutCliente))) {			
			this.rut_cliente = rutCliente;
		}
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		if(ValidarDatos.esDiaValido(dia)) {
			this.dia = dia;
		}
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		if(ValidarDatos.esHoraValida(hora)) {
			this.hora = hora;			
		}
	}

	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		if(ValidarDatos.RangoCaracteres(lugar, 10, 50)) {
			this.lugar = lugar;			
		}
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		if(ValidarDatos.RangoCaracteres(duracion, 0, 70)) {
			this.duracion = duracion;			
		}
	}

	public int getCantidadAsistentes() {
		return cantidad_asistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		if(ValidarDatos.Numero(String.valueOf(cantidadAsistentes), 0, 1000)) {
			this.cantidad_asistentes = cantidadAsistentes;			
		}
	}

	@Override
	public String toString() {
		return "Capacitacion [id=" + Id + ", nombre=" + nombre + ", detalle=" + detalle + ", rutCliente=" + rut_cliente
				+ ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion
				+ ", cantidadAsistentes=" + cantidad_asistentes + "]";
	}
	
	
	
}
