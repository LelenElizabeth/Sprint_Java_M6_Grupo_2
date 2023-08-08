package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "visitas")
public class Visitas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "rut_cliente", referencedColumnName = "rut")
    private Cliente cliente;
	private LocalDateTime fecha_hora;
	private String lugar;
	private String comentarios;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "profesional_id", referencedColumnName = "id")
	private Profesional profesional;
	
	@OneToMany(mappedBy = "visitas", cascade = CascadeType.ALL)
    private List<Chequeo> chequeos;
	public Visitas() {
	}
	
	public Visitas(int id, Cliente cliente, LocalDateTime fecha_hora, String lugar, String comentarios,
			int profesional_id) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fecha_hora = fecha_hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}
	public Visitas(Cliente cliente, LocalDateTime fecha_hora, String lugar, String comentarios,
			Profesional profesional) {
		super();
		this.cliente = cliente;
		this.fecha_hora = fecha_hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
		this.profesional = profesional;
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

	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public List<Chequeo> getChequeos() {
		return chequeos;
	}

	public void setChequeos(List<Chequeo> chequeos) {
		this.chequeos = chequeos;
	}

	@Override
	public String toString() {
		return "Visitas [id=" + id + ", cliente=" + cliente + ", fecha_hora=" + fecha_hora + ", lugar=" + lugar
				+ ", comentarios=" + comentarios + ", profesional=" + profesional + ", chequeos=" + chequeos + "]";
	}

	
	


	

}
