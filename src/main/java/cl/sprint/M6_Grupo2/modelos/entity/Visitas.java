package cl.sprint.M6_Grupo2.modelos.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cl.sprint.M6_Grupo2.utils.ValidarDatos;

@Entity
@Table(name="visitas")
public class Visitas {
	
	
	@Id
	@Column(name="id")
	private int id;
	@Column (name="rut_cliente")
	private int rut_cliente;
	private LocalDate fecha_visita;
	private String hora;
	private String lugar;
	private String comentarios;
	private int profesional_id;
	@OneToMany(mappedBy = "visitas", cascade = CascadeType.ALL)
    private List<Chequeo> chequeos;
	
	public Visitas() {
	}
	
	//Constructor formulario
	
	public Visitas(int id, int rut_cliente, LocalDate fecha_visita, String hora, String lugar, String comentarios,
			int profesional_id) {
		super();
		setId(id);
		setRut_cliente(rut_cliente);
		setFecha_visita(fecha_visita);
		setHora(hora);
		setLugar(lugar);
		setComentarios(comentarios);
		setProfesional_id(profesional_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(ValidarDatos.esObligatorio(String.valueOf(id))) {
		this.id = id;
		}
	}

	public int getRut_cliente() {
		return rut_cliente;
	}

	public void setRut_cliente(int rut_cliente) {
		this.rut_cliente = rut_cliente;
	}
	public LocalDate getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(LocalDate fecha_visita) {
		this.fecha_visita = fecha_visita;
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
		this.lugar = lugar;
	}	
		
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public int getProfesional_id() {
		return profesional_id;
	}

	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}


}
